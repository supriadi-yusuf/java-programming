package com.s03.oop;

abstract class Animal { // because it's method is abstract this class should be abstract too
    abstract void run(); // no need implementation because it is abstract method
}

class Giraffe extends Animal{
    @Override
    void run() {
        System.out.println("run by feet");
    }
}

public class P078AbstactMethod {
    public static void main(String[] args) {
        Animal animal = new Giraffe();
        animal.run();
    }
}
