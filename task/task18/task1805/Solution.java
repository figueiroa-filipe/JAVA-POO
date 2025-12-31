package com.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String caminho = reader.readLine();
        FileInputStream input = new FileInputStream(caminho);
        HashSet<Integer> set = new HashSet<>();
        while (input.available() > 0) {
            set.add(input.read());
        }
        input.close();
        reader.close();
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        l.forEach(e -> System.out.print(e + " "));
    }
}
