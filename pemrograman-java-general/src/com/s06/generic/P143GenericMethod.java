package com.s06.generic;

public class P143GenericMethod {

    public static class GenClass{
        public <T> void say(T data){
            System.out.println(data);
        }
    }

    public static  <T> void say(T data){
        System.out.println(data);
    }

    public static void main(String[] args) {
        say("hello semuanya apa kabar?");

        GenClass genClass = new GenClass();
        genClass.<String>say("helo semua");
        genClass.say("helo semua");
        genClass.<Integer>say(1234);
        genClass.say(1234);
        genClass.<Double>say(200000000d);
        genClass.say(200000000d);
    }

}
