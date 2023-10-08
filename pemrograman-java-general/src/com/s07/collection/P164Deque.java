package com.s07.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// Deque (Double Queue) => FIFO, LIFO

// Deque is child of Queue
// Dequeue is implemented by ArrayDeque and LinkedList

public class P164Deque {
    public static void main(String[] args) {

        System.out.println("=== ArrayDeque ===");
        Deque<String> arrayDeque = new ArrayDeque<>(10);
        processDequeFIFO(arrayDeque);
        processDequeLIFO(arrayDeque);

        System.out.println("\n=== LinkedList ====");
        Deque<String> linkedList = new LinkedList<>();
        processDequeFIFO(linkedList);
        processDequeLIFO(linkedList);

    }

    public static void processDequeFIFO(Deque<String> deque){

        System.out.println("\nFIFO : ");

        deque.offerLast("Supriadi");
        deque.offerLast("Syafeie");
        deque.offerLast("Muhammad");
        deque.offerLast("Yusuf");

        System.out.println(deque.size());

        for(String next=deque.pollFirst(); next!=null; next= deque.pollFirst()){
            System.out.println(next);
        }

        System.out.println(deque.size());

    }

    public static void processDequeLIFO(Deque<String> deque){

        System.out.println("\nLIFO : ");

        deque.offerLast("Supriadi");
        deque.offerLast("Syafeie");
        deque.offerLast("Muhammad");
        deque.offerLast("Yusuf");

        System.out.println(deque.size());

        for(String next=deque.pollLast(); next!=null; next= deque.pollFirst()){
            System.out.println(next);
        }

        System.out.println(deque.size());

    }
}
