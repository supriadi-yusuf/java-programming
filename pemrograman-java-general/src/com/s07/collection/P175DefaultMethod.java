package com.s07.collection;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class P175DefaultMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            list.add(i);
        }

        System.out.println(list);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (integer % 10 == 0) {
                    System.out.println(integer);
                }
            }
        });

        list.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                if (integer % 3 == 0) {
                    return 1;
                }
                return integer;
            }
        });

        System.out.println(list);

        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        });

        System.out.println(list);
    }
}
