package com.s06.generic;

// by default generic is invariant
// invariant means we can not substitute from sub type into super type or vice versa

public class P144Invariant {
    public static class MyData<T>{}

    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>();
        MyData<Object> objectMyData;
//        objectMyData = stringMyData; //sub class -> super class : error because generic is invariant

        MyData<Object> objectMyData1 = new MyData<>();
        MyData<String> stringMyData1;
//        stringMyData1 = objectMyData1; // super class -> sub class : error because generic is invariant
    }
}
