package com.s04.standard;

import java.util.Objects;

// Objects class ( not Object class) has many static method

public class P115Objects {
    public static class Data {
        private String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data1 = (Data) o;

            return data != null ? data.equals(data1.data) : data1.data == null;
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "MyData{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        execute(null);
        execute(new Data("test"));

    }

    public static void execute(Data data){
        int hashCode = Objects.hashCode(data); // we do not need to check manually if data is null or not, Objects class will do it
        System.out.println(hashCode);

        String string = Objects.toString(data); // we do not need to check manually if data is null or not
        System.out.println(string);

    }
}
