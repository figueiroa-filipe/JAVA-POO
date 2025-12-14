package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
User, loser, coder and programmer

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String USER = "user";
        final String LOSER = "loser";
        final String CODER = "coder";
        final String PROGRAMMER = "programmer";
        ArrayList<Person> people = new ArrayList<>();
        Person person = null;
        String key = null;



        while (true) {
            key = reader.readLine();
            if (key.equals(USER)) {
                person = new Person.User();
            }
            else if (key.equals(LOSER)) {
                person = new Person.Loser();
            }
            else if (key.equals(CODER)){
                person = new Person.Coder();
            }
            else if (key.equals(PROGRAMMER)) {
                person = new Person.Programmer();
            }
            else break;
            people.add(person);
        }

        // Here's the loop for reading the keys. Item 1
        for (int o = 0; o < people.size(); o++){
            // Create an object. Item 2
            person = people.get(o);
            doWork(person); // Call doWork
        }
    }

    public static void doWork(Person person) {
        // Item 3
        if (person instanceof Person.User) ((Person.User) person).live();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder) ((Person.Coder) person).writeCode();
        else if (person instanceof Person.Programmer) ((Person.Programmer) person).enjoy();

    }
}
