package com.s01.dasar;

public class P016Block {
    {
        System.out.println("hello ini bukan block static");
    }

    static {
        System.out.println("Hello ini block static");
    }

    public static void main(String[] args) {
        new P016Block();

        {
            System.out.println("ini block dalam method");

            {
                System.out.println("ini block di dalam block");
            }
        }

    }
}
