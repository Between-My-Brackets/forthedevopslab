package com.exam;

import com.google.gson.Gson;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class App {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        String env = System.getProperty("env.name");

        System.out.println("Environment: " + env);

        System.out.println("Sum = " + add(10,20));

        Gson gson = new Gson();
        Student s = new Student("Ravi",21);

        System.out.println("Student JSON: " + gson.toJson(s));
    }
}