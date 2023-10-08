package com.s16.thread;

import java.util.Random;
import java.util.concurrent.*;

public class P321CompletionService {
    public static void main(String[] args) {

        Random random = new Random();

        // CompletionService is interface to separate between thread who submit task and thread who receive result
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executorService);

        // submit task
        ExecutorService submitter = Executors.newSingleThreadExecutor();
        submitter.execute(()->{
            for (int i=1;i<=100;i++){
                final var task = i;
                executorCompletionService.submit(()->{
                    Thread.sleep(random.nextInt(2_000));
                    return "Task-" + task;
                });
            }
        });

        // poll complete task
        ExecutorService receiver = Executors.newSingleThreadExecutor();
        receiver.execute(()->{
            while (true){
                try {
                    Future<String> future = executorCompletionService.poll(5, TimeUnit.SECONDS);
                    if (future==null){
                        break;
                    }else {
                        String result = future.get();
                        System.out.println(result);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            executorService.shutdown();
        });

        submitter.shutdown();
        receiver.shutdown();

    }

}
