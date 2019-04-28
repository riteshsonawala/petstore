package com.rs;

public class Car implements Vehicle {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
