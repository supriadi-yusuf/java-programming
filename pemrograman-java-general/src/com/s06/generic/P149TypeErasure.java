package com.s06.generic;

// we have to be careful if we do omitting type for generic class

public class P149TypeErasure {
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

        MyData<String> supriadiMyData = new MyData<>("Supriadi");
        String supriadiMyDataData = supriadiMyData.getData();
        System.out.println(supriadiMyDataData);

        MyData myData = new MyData("Yusuf"); // omitting type (type erasure), it should be : MyData<String> myData = new MyData<>("Yusuf");
        MyData<Integer> integerMyData = (MyData<Integer>) myData;
//        Integer data = integerMyData.getData(); // ok at compile time but error at run time. this is why type erasure is dangerous


    }
}
