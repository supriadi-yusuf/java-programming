package com.s16.thread;

import java.util.concurrent.*;

public class P338ReactiveStream {
    private static class SimpleSubscriber implements Flow.Subscriber<String> {

        private String name;
        private long sleep;

        private Flow.Subscription subscription;

        public SimpleSubscriber(String name, long sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        @Override // first method executed
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1); // request data to publisher
        }

        @Override // when data is received
        public void onNext(String item) {
            try {
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ", " + this.name + " receive : " + item);
                this.subscription.request(1); // request data to publisher again
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // when error happen
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override // when no more data to send by publisher
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " : DONE");
        }
    }

    private static class SimpleProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

        public SimpleProcessor(Executor executor, int maxBufferCapacity) {
            super(executor, maxBufferCapacity);
        }

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(100);
                String data = "hello " + item;
                submit(data);// submit to subscriber
                System.out.println(Thread.currentThread().getName() + " processor receive : " + item + ", send : " + data);
                this.subscription.request(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            close();//close publisher
        }
    }

    private static void p01WithDefaultbuffer() throws InterruptedException {
        Flow.Subscriber subscriber1 = new SimpleSubscriber("subA", 1000);
        Flow.Subscriber subscriber2 = new SimpleSubscriber("subB", 500);

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        pool.execute(() -> {
            for (int i = 0; i < 300; i++) {
                publisher.submit("data-" + i);
                System.out.println(Thread.currentThread().getName() + " sends : data-" + i);
            }
        });

        pool.awaitTermination(301, TimeUnit.SECONDS);
        pool.shutdown();
    }

    private static void p02ChangeDefaultbuffer() throws InterruptedException {
        Flow.Subscriber subscriber1 = new SimpleSubscriber("subA", 1000);
        Flow.Subscriber subscriber2 = new SimpleSubscriber("subB", 500);

        ExecutorService forkJoinPool = Executors.newWorkStealingPool();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>(forkJoinPool, 50); // use another constructor to create SubmissionPublisher
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        pool.execute(() -> {
            for (int i = 0; i < 300; i++) {
                publisher.submit("data-" + i);
                System.out.println(Thread.currentThread().getName() + " sends : data-" + i);
            }
        });

        pool.awaitTermination(301, TimeUnit.SECONDS);
        pool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        // Reactive stream focuses on data flow. Implemented by class Flow
        // Publisher : sender, Subscriber : receiver
        // Publisher is implemented by interface Flow.Publisher
        // Subscriber is implemented by interface Flow.Subscriber
        // Default publisher buffer size is 256

//        p01WithDefaultbuffer();
//        p02ChangeDefaultbuffer();

        // Processor : publisher sekaligus subscriber
        // Publisher -> Processor-> Subscriber

        ExecutorService forkJoinPool = Executors.newWorkStealingPool();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>(forkJoinPool, 50);
        SimpleProcessor processor = new SimpleProcessor(forkJoinPool, 50);
        publisher.subscribe(processor);

        SimpleSubscriber subscriber = new SimpleSubscriber("subA",1000);
        processor.subscribe(subscriber);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        pool.execute(() -> {
            for (int i = 0; i <= 300; i++) {
                publisher.submit("data-" + i);
                System.out.println(Thread.currentThread().getName() + " send : " + "data-" + i);
            }

        });

        pool.awaitTermination(301, TimeUnit.SECONDS);
        pool.shutdown();

    }
}
