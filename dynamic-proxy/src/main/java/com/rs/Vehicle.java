package com.rs;

public interface Vehicle{

    String name();
    default void start(){
        System.out.println("Default start");
    }
    default void stop(){
        System.out.println("Default stop");
    }
}
