package com.s07.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// Queue => FIFO

// Queue is child of interface Collection
// Queue has child interface Deque
// Queue is implemented by PriorityQueue, ArrayDeque and LinkedList
// Dequeue is implemented by ArrayDeque and LinkedList

public class P163Queue {
    public static void processQueue(Queue<String> queue){
        queue.add("Supriadi");
        queue.add("Syafeie");
        queue.add("Muhammad");
        queue.add("Yusuf");

        System.out.println(queue.size());

        for (String next = queue.poll();next!=null;next= queue.poll()){
            System.out.println(next);
        }

        System.out.println(queue.size());

    }

    public static void main(String[] args) {

        System.out.println("ArrayDeque : ");
        Queue<String> arrayDeque = new ArrayDeque<>(10);
        processQueue(arrayDeque);

        System.out.println("\nPriorityQueue : ");
        Queue<String> priorityQueue = new PriorityQueue<>();
        processQueue(priorityQueue);

        System.out.println("\nLinkedList : ");
        Queue<String> linkedList = new LinkedList<>();
        processQueue(linkedList);

    }
}
