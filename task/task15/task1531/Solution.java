package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static BigInteger fac(BigInteger n) {
        //write your code here
        if (n.compareTo(BigInteger.ZERO) < 0) return BigInteger.ZERO;
        if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        return n.multiply(fac(n.subtract(BigInteger.ONE)));
    }

    public static String factorial(int n) {
        //write your code here
        BigInteger bi = new BigInteger(String.valueOf(n));
        return (fac(bi)).toString();
    }
}
