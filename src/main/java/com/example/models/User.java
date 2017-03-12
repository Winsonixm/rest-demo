package com.example.models;

import java.math.BigDecimal;

public class User {

    private String id;

    private String name;

    private int age;

    private BigDecimal salary;

    public User(String id, String name, int age, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(){

    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}

