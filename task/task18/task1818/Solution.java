package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(reader.readLine());

        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        while (fileInputStream3.available() > 0){
            fileOutputStream.write(fileInputStream3.read());
        }
        reader.close();
        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
