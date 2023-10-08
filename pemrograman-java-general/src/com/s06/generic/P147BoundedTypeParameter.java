package com.s06.generic;

// Bound generic parameter into specific class

public class P147BoundedTypeParameter {
    public static interface CanSayHello {
        void sayHello(String name);
    }
    public static abstract class Employee{}
    public static class Manager extends Employee{}
    public static class VPresident extends Employee implements CanSayHello{
        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }
    public static class MyData<T extends Employee & CanSayHello /*& otherInterface*/>{
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

    public static void main(String[] args) {
//        MyData<Manager> managerData = new MyData<>(new Manager()); // error because Manager does not implement CanSayHello
        MyData<VPresident> vPresidentMyData = new MyData<>(new VPresident());

    }
}
