package com.s06.generic;

// interface Comparable<T> is needed to compare object
// so we know if object is equal, less or greater comparing to another object

import java.util.Arrays;

public class P150Comparable {
    public static class Person implements Comparable<Person>{
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return age.compareTo(o.age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {

        Person supriadi = new Person("Supriadi", 40);
        Person yudi = new Person("Yudi", 28);

        // comparing object
        int compareTo = supriadi.compareTo(yudi);
        System.out.println(compareTo);

        int comparedTo = yudi.compareTo(supriadi);
        System.out.println(comparedTo);

        Person[] people = {
                supriadi,
                yudi,
                new Person("Andika",50),
                new Person("Budi",23)
        };

        System.out.println(Arrays.toString(people));

        // we can do sorting
        Arrays.sort(people);

        System.out.println(Arrays.toString(people));

    }
}
