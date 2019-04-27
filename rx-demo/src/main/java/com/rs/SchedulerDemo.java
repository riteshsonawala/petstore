package com.rs;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerDemo {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 5000);
        observable.subscribeOn(Schedulers.computation()).blockingSubscribe(System.out::println, Throwable::printStackTrace, ()-> System.out.println("Done!"));
    }
}
