package com.example.models;

import java.math.BigDecimal;

public class Bus {

    private String id;

    private String name;

    private int age;

    private BigDecimal salary;
    
    private int number;

    public Bus(String id, String name, int age, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Bus(){

    }

    public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Bus setId(String id) {
        this.id = id;
        return this;
    }

    public Bus setName(String name) {
        this.name = name;
        return this;
    }

    public Bus setAge(int age) {
        this.age = age;
        return this;
    }

    public Bus setSalary(BigDecimal salary) {
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

