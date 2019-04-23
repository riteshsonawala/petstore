package com.rs;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObserverDemo {


    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 20);
        ConnectableObservable<Integer> co = observable.publish();

        co.subscribe(i-> System.out.println( "Source 1 " + i));
        co.subscribe(i-> System.out.println("Source 2 " + i));
        co.connect();
    }
}
