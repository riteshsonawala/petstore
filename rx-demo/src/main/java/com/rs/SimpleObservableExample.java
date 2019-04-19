package com.rs;

import io.reactivex.Observable;

public class SimpleObservableExample {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(Integer.valueOf(42));
        observable.subscribe(System.out::println);
    }

}
