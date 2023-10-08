package com.s06.generic;

import java.util.Arrays;
import java.util.Comparator;

// Comparator interface helps us to compare object class created by others which is impossible for us to modify it

public class P151Comparator {
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

        Person supriadi = new Person("Supriadi", 40);
        Person yudi = new Person("Yudi", 28);

        Comparator<Person> personComparator = new Comparator<>(){ // anynomous class
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };

        int compare = personComparator.compare(supriadi, yudi);
        System.out.println(compare);

        int compared = personComparator.compare(yudi, supriadi);
        System.out.println(compared);

        Person[] people = {
                supriadi,
                yudi,
                new Person("Andika",50),
                new Person("Budi",23)
        };

        System.out.println(Arrays.toString(people));

        // we can do sorting
        Arrays.sort(people,personComparator);

        System.out.println(Arrays.toString(people));

    }
}
