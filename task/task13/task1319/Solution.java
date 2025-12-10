package com.codegym.task.task13.task1319;

import java.io.*;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buffer = null;
        String content;
        try {
            buffer = new BufferedWriter(new FileWriter(reader.readLine()));

            while (true) {
                content = reader.readLine();
                if(content == null) break;
                buffer.newLine();
                buffer.write(content);
                if(content.equals("exit")) break;
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            reader.close();
            buffer.close();
        }
    }
}
