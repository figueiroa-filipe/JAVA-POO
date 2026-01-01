package com.codegym.task.task18.task1808;

/* 
Splitting a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();
            byte[] buffer = new byte[10000];
            FileInputStream origin = new FileInputStream(file1);
            FileOutputStream source2 = new FileOutputStream(file2);
            FileOutputStream source3 = new FileOutputStream(file3);
            int count = 0;
            while (origin.available() > 0) {
                count = origin.read(buffer);
            }
            if (count % 2 == 0) {
                for (int i = 0; i < count / 2; i++) {
                    source2.write(buffer[i]);
                }
                for (int i = count / 2; i < count; i++){
                    source3.write(buffer[i]);
                }
            } else {
                for (int i = 0; i < (count / 2)+1; i++) {
                    source2.write(buffer[i]);
                }

                for (int i = (count / 2)+1; i < count; i++) {
                    source3.write(buffer[i]);
                }
            }
            origin.close();
            source2.close();
            source3.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
