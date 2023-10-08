package com.s03.oop;

// anynomous class : creating object from interface by defining methods in it at creation time.



public class P089AnonymousClass {
    public static interface MyAnynomous {
        void hello();
    }

    public static void main(String[] args) {

        MyAnynomous myAnynomous = new MyAnynomous() {
            public void hello() {
                System.out.println("hello my bro");
            }
        };

        myAnynomous.hello();

    }
}
