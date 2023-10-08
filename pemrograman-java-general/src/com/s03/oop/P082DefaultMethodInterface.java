package com.s03.oop;
interface Vehicle {
    void info();
    default boolean isBig(){ // default method : class can override it or not
        return false;
    }
}

class Bike implements Vehicle{
    @Override
    public void info() {
        System.out.println("this is bike");
    }
}

public class P082DefaultMethodInterface {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.info();
        System.out.println(bike.isBig());
    }
}
