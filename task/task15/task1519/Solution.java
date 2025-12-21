package com.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Different methods for different types

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String value = reader.readLine();
            if ((value).equals("exit")) break;
            else {
                try {
                    if ((value).contains(".")) print(Double.parseDouble(value));
                    else {
                        int num = Integer.parseInt(value);
                        if (num > 0 && num < 128) print((short)num);
                        else print(num);
                    }

                } catch (RuntimeException e) {
                    print(value);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }
}
