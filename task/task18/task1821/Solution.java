package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] result = new int[128];
        try (FileReader fileReader = new FileReader(new File(args[0]))) {
            while (fileReader.ready()){
                result[fileReader.read()]++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < result.length; i++) {
            if(result[i] != 0) System.out.println((char)(i) + " " + result[i]);
        }
    }
}
