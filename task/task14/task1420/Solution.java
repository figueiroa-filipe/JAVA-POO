package com.codegym.task.task14.task1420;

/* 
GCD

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int num2 = 0;
        try {
            num = Integer.parseUnsignedInt(reader.readLine());
            num2 = Integer.parseUnsignedInt(reader.readLine());
            if (num == 0 || num2 == 0) throw new NumberFormatException();
        } catch (NumberFormatException e){
            throw e;
        }
        int value = euclidean(num, num2);
        System.out.println(value);

    }

    public static int euclidean(int a, int b) {
        if (b == 0) return a;
        else return euclidean(b, a%b);
    }
}
