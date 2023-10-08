package com.s06.generic;

// generic class is a class with parameter type
// Notation : E (Element), K (Key), N (Number), T (Type), V (Value)
// S, U, V, etc types


public class P142GenericClass {
    public static class MyData<T>{
        private T data;

        public MyData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static class Pair<T,U>{
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond(U second) {
            this.second = second;
        }
    }

    public static interface IntGeneral<T>{
        void say(T data);
    }

    public static class ClsGeneral<T> implements IntGeneral<T>{
        @Override
        public void say(T data) {
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("test");
        MyData<Integer> integerMyData = new MyData<>(10);
        Pair<String, Integer> supriadi = new Pair<>("supriadi", 30);
        ClsGeneral<String> stringClsGeneral = new ClsGeneral<>();
        stringClsGeneral.say("hello apa kabar ?");


    }
}
