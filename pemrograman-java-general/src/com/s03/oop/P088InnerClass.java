package com.s03.oop;

class ClassOuter {
    private String name;

    public ClassOuter(String name) {
        this.name = name;
    }

    class InnerClass {
        private String name;

        public InnerClass(String name) {
            this.name = name;
        }

        public void hello(){
            System.out.println("outer class -> " + ClassOuter.this.name);
            System.out.println("inner class -> " + this.name);
        }
    }
}
public class P088InnerClass {
    public static void main(String[] args) {
        ClassOuter outer = new ClassOuter("Yamaha");
        ClassOuter.InnerClass inner = outer.new InnerClass("jaya yuda");
        inner.hello();
    }
}
