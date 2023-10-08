package com.s06.generic;

// contravariant allows super type to be substituted into sub type
// to make generic becomes contravariant we need to use ? super sub type
// example : class MyData<? super String>
// calling method that modifies data is not allowed

public class P146Contravariant {
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

        MyData<Object> objectMyData = new MyData<>(10);

        MyData<? super Integer> intMyData; // make contravariant
        intMyData = objectMyData;// ok
        Integer intVal = (Integer) intMyData.getData();
        System.out.println(intVal);
        intMyData.setData(100);//ok

        MyData<? super String> strMyData; // make contravariant
        strMyData = objectMyData;//ok
//        String data = (String) strMyData.getData(); // error ... be careful when reading data
        Object data = strMyData.getData();//ok
        System.out.println(data);
        strMyData.setData("hello how are you?");


    }
}
