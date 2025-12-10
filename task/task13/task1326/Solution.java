package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nomeArquivo = reader.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            FileInputStream fileStream = new FileInputStream(nomeArquivo);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStream));
            String linha;

            while ((linha = fileReader.readLine()) != null) {
                int num = Integer.parseInt(linha.trim());
                if (num%2 == 0) arr.add(num);
            }

            fileStream.close();
            fileStream.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        arr.stream().sorted().forEach(System.out::println);

    }
}
