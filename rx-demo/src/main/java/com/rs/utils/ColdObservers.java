package com.rs.utils;

import io.reactivex.Observable;

public class ColdObservers {

    public static void main(String[] args) {
        rangeAndmap();
        flatMapDemo();
    }

    private static void flatMapDemo() {

//        String [] arrayOfNames={"Ritesh", "Gyan", "Prashant", "Vijay", "Binny", "Sudhir", "Shibu", "Vinod", "Yogest"};
//        Observable.just(arrayOfNames).flatMap(i->{
//            int len=i.length;
//            return i + ("(" + len + ")")
//;        });
    }

    private static void rangeAndmap() {
        Observable.range(1,10)
                .map(i->i*i)
                .subscribe(System.out::println);
    }

}
