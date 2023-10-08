package com.s07.collection;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;

// spliterator : cut collection into two parts

public class P176Splitrator {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            list.add(i);
        }

        System.out.println("list size : " + list.size());

        Spliterator<Integer> spliterator = list.spliterator();
        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        Spliterator<Integer> spliterator3 = spliterator2.trySplit();

        System.out.println("spliterator size : " + spliterator.estimateSize());
        System.out.println("spliterator2 size : " + spliterator2.estimateSize());
        System.out.println("spliterator3 size : " + spliterator3.estimateSize());

        Consumer<Integer> action = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + "  ");
            }
        };

        System.out.println("\n====== spliterator =====");
        spliterator.forEachRemaining(action);

        System.out.println("\n\n====== spliterator2 =====");
        spliterator2.forEachRemaining(action);

        System.out.println("\n\n====== spliterator3 =====");
        spliterator3.forEachRemaining(action);

    }
}
