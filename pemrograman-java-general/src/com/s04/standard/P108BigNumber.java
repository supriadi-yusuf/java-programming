package com.s04.standard;

import java.math.BigDecimal;
import java.math.BigInteger;

// BigInteger is to store data whose size is more than size of long type
// BigDecimal is to store data whose size is more than size of double

public class P108BigNumber {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("123");
        BigInteger bigIntVal = new BigInteger("4000");
        BigInteger bigIntegerResult = bigInteger.add(bigIntVal);
        System.out.println(bigIntegerResult.toString());

        BigDecimal bigDecimal = new BigDecimal("200");
        BigDecimal bigDecimalResult = bigDecimal.add(new BigDecimal("1000"));
        System.out.println(bigDecimalResult.toString());
    }
}
