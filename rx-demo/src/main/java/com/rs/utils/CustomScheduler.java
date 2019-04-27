package com.rs.utils;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 5000);
        ExecutorService executorService=Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(executorService);
        observable.subscribeOn(scheduler).doFinally(executorService::shutdown).subscribe(System.out::println, Throwable::printStackTrace, ()-> System.out.println("Done!"));
    }
}
