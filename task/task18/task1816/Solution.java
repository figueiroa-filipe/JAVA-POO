package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File(args[0]));
        int count = 0;

        while (file.available() > 0) {
            char c = (char) file.read();
            if (c >= 'a' && c <= 'z' || (c >= 'A' && c <= 'Z')) count++;
        }
        file.close();
        System.out.println(count);
    }
}
