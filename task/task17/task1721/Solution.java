package com.codegym.task.task17.task1721;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {
        String firstFile = null;
        String secondFile = null;
        Solution solution = new Solution();
        try (Scanner sc = new Scanner(System.in)) {
            firstFile = sc.nextLine();
            secondFile = sc.nextLine();
            lerLinhas(allLines, firstFile);
            lerLinhas(linesForRemoval, secondFile);
            solution.joinData();
        } catch (CorruptedDataException e) {
            throw new RuntimeException(e);
        }

    }

    public static void lerLinhas(List<String> list, String fileName){
        try{
            List<String> linhas = Files.readAllLines(Paths.get(fileName));
            for (String linha : linhas) list.add(linha);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(linesForRemoval)) {
            // Se allLines CONTÉM todos os elementos de linesForRemoval
            allLines.removeAll(linesForRemoval);
        } else {
            // Se faltam elementos, dados corrompidos
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
