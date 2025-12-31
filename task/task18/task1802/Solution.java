package com.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream input = new FileInputStream(reader.readLine());
            int min = Integer.MAX_VALUE;
            while (input.available() != -1) {
                min = Math.min(min, input.read());
            }
            System.out.println(min);
            input.close();
        }
    }
}
