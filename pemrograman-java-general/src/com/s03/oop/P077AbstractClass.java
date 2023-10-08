package com.s03.oop;

abstract class Shape{}

class Rectangle extends Shape{}

public class P077AbstractClass {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        System.out.println(shape.toString());
    }
}
