package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String nome = args[i];
                        String sexo = args[i + 1];
                        Date data = null;
                        try {
                            SimpleDateFormat formato = new SimpleDateFormat("MM dd yyyy");
                            data = formato.parse(args[i + 2]);
                        } catch (ParseException e) {
                        }
                        criarPessoa(nome, sexo, data);
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        String nome = args[i + 1];
                        String sexo = args[i + 2];
                        Date data = null;
                        try {
                            SimpleDateFormat formato = new SimpleDateFormat("MM dd yyyy");
                            data = formato.parse(args[i + 3]);
                        } catch (ParseException e) {
                        }
                        criarPessoa(nome, sexo, data, id);
                    }

                    break;
                }

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) deletePessoa(Integer.parseInt(args[i]));
                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])));
                    }
                    break;
                }

            default:
                synchronized (allPeople) {
                    break;
                }
        }
    }

    private static void criarPessoa(String nome, String sexo, Date data) {
        if (sexo.equals("m")) allPeople.add(Person.createMale(nome, data));
        else if(sexo.equals("f")) allPeople.add(Person.createFemale(nome, data));
        System.out.println(allPeople.size() - 1);
    }

    private static void criarPessoa(String nome, String sexo, Date data, int id){
        if (sexo.equals("m")) allPeople.set(id, Person.createMale(nome, data));
        else if(sexo.equals("f")) allPeople.set(id, Person.createFemale(nome, data));
    }

    private static void deletePessoa(int id){
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }
}
