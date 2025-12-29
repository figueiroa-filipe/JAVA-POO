package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        String op = args[0];
        if (op.equals("-c")) {
            criarPessoa(args);
        }
        else if(op.equals("-u")) {
            criarPessoa(args, Integer.parseInt(args[1]));
        }
        else if(op.equals("-d")) {
            deletePessoa(args);
        }
        else if(op.equals("-i")) {
            System.out.println(allPeople.get(Integer.parseInt(args[1])));
        }
    }

    private static void deletePessoa(String[] args){
        allPeople.get(Integer.parseInt(args[1])).setName(null);
        allPeople.get(Integer.parseInt(args[1])).setSex(null);
        allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
    }

    private static void criarPessoa(String[] args, int id){
        String sex = args[3];
        String name = args[2];
        Date data = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("MM dd yyyy");
            data = formato.parse(args[4]);
        } catch (ParseException e) {}
        if (sex.equals("m")) allPeople.set(id, Person.createMale(name, data));
        else if(sex.equals("f")) allPeople.set(id, Person.createFemale(name, data));
    }

    private static void criarPessoa(String[] args) {
        String sex = args[2];
        String name = args[1];
        Date data = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("MM dd yyyy");
            data = formato.parse(args[3]);


        } catch (ParseException e) {}
        if (sex.equals("m")) allPeople.add(Person.createMale(name, data));
        else if(sex.equals("f")) allPeople.add(Person.createFemale(name, data));
        System.out.println(allPeople.size() - 1);
    }
}
