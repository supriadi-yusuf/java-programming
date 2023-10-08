package com.s06.generic;

public class P148Wildcard {
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
        MyData<String> stringMyData = new MyData<String>("supriadi");
        MyData<?> anyData;
        anyData = stringMyData; // ok
        Object data = anyData.getData(); // ok
        System.out.println(data);

    }
}
