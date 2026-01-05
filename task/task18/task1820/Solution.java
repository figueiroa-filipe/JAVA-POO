package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFileName));
             PrintWriter printWriter = new PrintWriter(new FileWriter(secondFileName))){

            while (bufferedReader.ready()) {
                String[] bufferValues = bufferedReader.readLine().split(" ");
                for (String bufferValue : bufferValues) {
                    double doubleValue = Double.parseDouble(bufferValue);
                    long intValue = Math.round(doubleValue);
                    printWriter.write(intValue + " ");
                }
            }
        }
    }
}
