package com.s07.collection;

import java.util.EnumSet;
import java.util.Set;

// EnumSet is a set whose member is enum

public class P159bEnumSet {
    public static enum Gender {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        System.out.println("================ Enum Set =============================");
//        Set<Gender> genders = EnumSet.allOf(Gender.class);
        Set<Gender> genders = EnumSet.of(Gender.MALE, Gender.FEMALE);
        showSet(genders);
    }

    private static void showSet(Set<? extends Object> set) {
        for(var data : set){
            System.out.println(data);
        }
    }
}
