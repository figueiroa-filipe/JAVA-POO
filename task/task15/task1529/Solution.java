package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Mastering the static block

*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //write your code here
        result = Solution::reset;
    }

    public static CanFly result;

    public static void reset() {
        //write your code here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String value = reader.readLine();
            if (value.equals("helicopter")) result = new Helicopter();
            else if(value.equals("plane")){
                int numberOfPassagers = Integer.parseInt(reader.readLine());
                result = new Plane(numberOfPassagers);
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
