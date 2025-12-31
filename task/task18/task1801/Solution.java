package com.codegym.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Maximum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        int max = Integer.MIN_VALUE;
        while (input.available() > 0) {
            max = Math.max(max, input.read());
        }
        reader.close();
        input.close();
        System.out.println(max);
    }
}
