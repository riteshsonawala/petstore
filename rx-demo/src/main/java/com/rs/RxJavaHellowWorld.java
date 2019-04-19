package com.rs;

import io.reactivex.Flowable;

public class RxJavaHellowWorld {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
