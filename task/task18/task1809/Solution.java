package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            FileInputStream file1 = new FileInputStream(reader.readLine());
            FileOutputStream file2 = new FileOutputStream(reader.readLine());
            byte[] buffer = new byte[1000];
            int count = 0;
            while (file1.available() > 0) {
                count = file1.read(buffer);
            }

            for (int i = count - 1; i >= 0; i--)  {
                file2.write(buffer[i]);
            }

            file1.close();
            file2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
