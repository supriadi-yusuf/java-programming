package com.s06.generic;

// covariant allows sub type to be substituted into super type
// to make generic becomes covariant we need to use ? extends super type
// example : class MyData<? extends Object>
// calling method that modifies data is not allowed

public class P145Covariant {
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

    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<>("hello");
        MyData<? extends Object> objMyData; // make covariant
        objMyData = stringMyData; // ok

        objMyData.getData(); // ok
//        objMyData.setData("ttr"); // compile error ... calling method that modifies data is not allowed

    }
}
