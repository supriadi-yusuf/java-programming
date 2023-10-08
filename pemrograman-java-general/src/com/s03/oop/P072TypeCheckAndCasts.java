package com.s03.oop;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void helloEmployee(){
        System.out.println("Hello Employee " + name);
    }
}

class Foreman extends Employee{
    public Foreman(String name) {
        super(name);
    }

    public void helloForeman(){
        System.out.println("Hello Foreman " + getName());
    }
}

public class P072TypeCheckAndCasts {
    public static void main(String[] args) {

        checkObject(new Object());
        checkObject(new Employee("susi"));
        checkObject(new Foreman("herlambang"));

        System.out.println(new Object() instanceof Foreman);
//        System.out.println(new Integer(10) instanceof Employee);

    }

    public static void checkObject(Object o){
        if ( o instanceof Foreman) { // type checking
            ((Foreman)o) // type cast
                    .helloForeman();
        } else if (o instanceof Employee) { // type checking
            ((Employee)o) // type cast
                    .helloEmployee();
        }else {
            System.out.println("unknown object");
        }
    }
}
