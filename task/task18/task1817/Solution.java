package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        int n1 = 0;
        int n2 = 0;
        FileInputStream fileStream = new FileInputStream(new File(args[0]));
        while (fileStream.available() > 0) {
            char c = (char) fileStream.read();
            if (Character.isSpaceChar(c)) n2++;
            n1++;
        }
        fileStream.close();
        DecimalFormat dc = new DecimalFormat("#.##");
        double value = (1.0*n2/n1)*100;
        System.out.println(dc.format(value));
    }
}
