package com.s07.collection;

import java.util.*;

// Sorted set is set whose elements are sorted

// SortedSet is child of Set
// SortedSet is implemented by TreeSet

public class P161SortedSet {

    public static class Person{
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
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Comparator<Person> personComparator = new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };

        System.out.println("============ Sorted Set Ascending ====================");
        SortedSet<Person> people = new TreeSet<>(personComparator);
        processSet(people);

        System.out.println("============ Sorted Set Descending ====================");
        SortedSet<Person> peopleDesc = new TreeSet<>(personComparator.reversed());
        processSet(peopleDesc);

    }

    public static void processSet(Set<Person> people){
        people.add(new Person("endang",20));
        people.add(new Person("Yosi",13));
        people.add(new Person("Imran",17));

        for(var person:people){
            System.out.println(person.getAge());
        }
    }
}
