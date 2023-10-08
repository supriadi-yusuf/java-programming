package com.s04.standard;

// number that is not primitive type ( Integer, Long, etc) has same parent. the parent is Number class.

public class P106NumberClass {
    public static void main(String[] args) {

        Integer value = 10;

        // convert from number to another number type
        byte byteValue = value.byteValue();
        Byte byteValue2 = value.byteValue();

        long longValue = value.longValue();
        Long longValue2 = value.longValue();

        double doubleValue = value.doubleValue();
        Double doubleValue2 = value.doubleValue();

        short shortValue = value.shortValue();
        Short shortValue2 = value.shortValue();

        // convert number to string
        String strValue = String.valueOf(value);

        // convert string to primitive number, use parseXX() method
        int intValue = Integer.parseInt(strValue);

        // convert string to non primitive number, use valueOf() method
        Integer integer = Integer.valueOf(strValue);

    }
}
