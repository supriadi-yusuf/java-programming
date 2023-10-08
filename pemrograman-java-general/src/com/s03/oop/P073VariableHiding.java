package com.s03.oop;

class Parent {
    String name;

    void doIt(){
        System.out.println("Do it in parent");
    }
}
class Child extends Parent {
    String name;

    void doIt(){
        System.out.println("Do it in child");
    }
}

// there is method overriding but there is not variable overriding
// there is variable hiding
public class P073VariableHiding {
    public static void main(String[] args) {

        Child child = new Child();
        child.name = "supriadi";
        child.doIt();
        System.out.println(child.name); // supriadi

        Parent parent = child;
        parent.doIt();
        System.out.println(parent.name); // null

    }
}
