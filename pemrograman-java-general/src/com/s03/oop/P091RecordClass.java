package com.s03.oop;

// record is only to store data
// record is immutable. we can store and get but we cannot modify it
// record can implement interface but it cannot extends any class
// record must have constructor

public class P091RecordClass {
    public static interface StudentRecordInterface{
        void sayHello();
    }

    public static record StudentRecord(String name, String city) implements StudentRecordInterface{

        public StudentRecord {// it is called before field value is assigned
            System.out.println("ini dipanggil");
            System.out.println("My name is " + this.name());
        }

        // overload constructor
        StudentRecord(String name){
            this(name, "");// call main constructor
        }

        public StudentRecord(){
            this("","");
        }

        @Override
        public void sayHello() {
            System.out.println("Hello my name is " + this.name);
        }
    }

    public static void main(String[] args) {

        StudentRecord student = new StudentRecord("Almira", "Jakarta");
        student.sayHello();
        System.out.println(student.city());
        System.out.println(student);

        StudentRecord studentAli = new StudentRecord("Ali");
        studentAli.sayHello();

    }
}
