package com.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        //write your code here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String url = reader.readLine();
            url = url.substring(url.indexOf('?') + 1);
            String[] urlSplit = url.split("&");
            ArrayList<String> listaPalavras = new ArrayList<>();
            String isObjPresent = null;
            for (String s : urlSplit) {
                if (s.contains("obj")) {
                    isObjPresent = s.substring(s.indexOf("=")+1);
                }
                if (s.contains("=")) {
                    String temp = s.substring(0, s.indexOf("="));
                    listaPalavras.add(temp);
                } else listaPalavras.add(s);

            }
            System.out.println(String.join(" ", listaPalavras));
            if (isObjPresent != null) {
                try {
                    Double value = Double.parseDouble(isObjPresent);
                    alert(value);
                } catch (NumberFormatException e) {
                    alert(isObjPresent);
                }
            }
        }
        catch (IOException e){

        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
