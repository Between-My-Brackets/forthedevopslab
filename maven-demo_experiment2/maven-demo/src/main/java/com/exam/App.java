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
    public static void main(String[] args) {
        Gson gson = new Gson();
        Student s = new Student("Ravi", 21);
        System.out.println(gson.toJson(s));
    }
}