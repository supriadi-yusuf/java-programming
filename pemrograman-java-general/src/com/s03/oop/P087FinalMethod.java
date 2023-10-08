package com.s03.oop;

class ClassWithFinalMethod {
    public void hello(){
        System.out.println("hello semua ....");
    }
    public final void info(){ // final method can not be overriden
        System.out.println("final method");
    } // this is final method so it can not be over riden
}

class ChildOfClassWithFinalMethod extends ClassWithFinalMethod {
    @Override
    public void hello() {
        System.out.println("hi how are you?");
    }
}


public class P087FinalMethod {
    public static void main(String[] args) {

    }
}
