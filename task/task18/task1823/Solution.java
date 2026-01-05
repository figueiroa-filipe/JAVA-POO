package com.codegym.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Threads and bytes

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String fileName = reader.readLine();
                if (fileName.equals("exit")) break;
                ReadThread r = new ReadThread(fileName);
                r.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] counter = new int[256];
            int ans = 0;
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(this.fileName));
                while (fileInputStream.available() > 0){
                    int value = fileInputStream.read();
                    counter[value]++;
                    if (counter[value] > counter[ans]) ans = value;
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            resultMap.put(this.fileName, ans);
        }
        // Implement file reading here
    }
}
