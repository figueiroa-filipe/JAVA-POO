package com.codegym.task.task15.task1517;

/* 
Static modifiers and exceptions

*/

public class Solution {
    public static int A = 0;

    static {
        // Throw an exception here
        try
        {
            throw new ExceptionInInitializerError();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getException().getStackTrace());
        }
    }

    public static int B = 5;

    static {

    }

    public static void main(String[] args) {
        System.out.println(B);
    }
}
