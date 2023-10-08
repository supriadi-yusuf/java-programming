package com.s03.oop;

class Manager {
    String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void sayHello(String name){
        System.out.println("Hello "+ name + ", I am Manager " +  this.name);
    }
}

class VicePresident extends Manager{
    public VicePresident(String name) {
        super(name);
    }

    @Override
    void sayHello(String name) {
        System.out.println("Hello " + name + ", I am VP " + getName());
    }

}

// overriding adalah mendefinisikan ulang method yang sudah didefinisikan di parent class
public class P067MethodOverriding {
    public static void main(String[] args) {

        VicePresident vicePresident = new VicePresident("Ali");
        vicePresident.sayHello("Mandra");

    }
}
