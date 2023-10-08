package com.s17.reflection.classes;

import java.io.Serializable;

public class Data<T extends AutoCloseable & Serializable>{

    private T data;

    public Data() {
    }

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
