package com.codegym.task.task14.task1404;

/* 
Cats

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String var = reader.readLine();
            if (var.isEmpty()) break;
            Cat tempCat = CatFactory.getCatByKey(var);
            System.out.println(tempCat.toString());
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat;
            switch (key) {
                case "feral":
                    cat = new MeanCat("Claws");
                    break;
                case "miss":
                    cat = new NiceCat("Missy");
                    break;
                case "smudge":
                    cat = new NiceCat("Smudgey");
                    break;
                default:
                    cat = new Cat(key);
                    break;
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "I'm " + getName() + ", an alley cat";
        }
    }

    static class MeanCat extends Cat {
        MeanCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm " + getName() + ", and I'm going to claw your eyes out";
        }
    }

    static class NiceCat extends Cat {
        NiceCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm a nice kitten named " + getName();
        }
    }
}
