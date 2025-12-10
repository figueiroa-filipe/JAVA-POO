package com.codegym.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream file = null;

        try {
            String name = reader.readLine();
            file = new FileInputStream(name);
            int content;

            while ((content = file.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            reader.close();
            file.close();
        }
    }
}