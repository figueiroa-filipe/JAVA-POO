package com.codegym.task.task18.task1810;

/* 
DownloadException

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                FileInputStream input = new FileInputStream(reader.readLine());
                byte[] buffer = new byte[1000];
                int count = 0;
                while (input.available() > 0) {
                    count += input.read(buffer);
                }
                if (count < 1000) {
                    input.close();
                    reader.close();
                    throw new DownloadException();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
