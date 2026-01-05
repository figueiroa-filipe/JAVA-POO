package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        FileInputStream firstFileInputStream = new FileInputStream(firstFileName);
        FileOutputStream firstFileOutputStream = new FileOutputStream(firstFileName);
        FileInputStream secondFileInputStream = new FileInputStream(secondFileName);

        while (secondFileInputStream.available() > 0) {
            firstFileOutputStream.write(secondFileInputStream.read());
        }

        while (firstFileInputStream.available() > 0) {
            firstFileOutputStream.write(firstFileInputStream.read());
        }

        reader.close();
        firstFileOutputStream.close();
        firstFileInputStream.close();
        secondFileInputStream.close();
    }
}
