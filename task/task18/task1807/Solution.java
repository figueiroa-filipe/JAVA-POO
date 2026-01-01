package com.codegym.task.task18.task1807;

/* 
Counting commas

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream input = new FileInputStream(fileName)) {
            int count = 0;
            while (input.available() > 0) {
                int value = input.read();
                if ((char)value == ',') count++;
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
