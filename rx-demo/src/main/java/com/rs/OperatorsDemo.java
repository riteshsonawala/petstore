package com.rs;

import io.reactivex.Observable;

import java.util.List;

public class OperatorsDemo {


    public static void main(String[] args) {
        demonstrateBuffer();
        demonstrateScan();

    }

    private static void demonstrateBuffer() {
        Observable.fromArray("Ritesh", "Gyan", "Prashant", "Binny", "Sudhir", "Shibu", "Vinod", "Yogesh", "Vijay")
                .buffer(2)
                .subscribe(
                        (List<String> pair) -> {
                            System.out.println(String.join(" & ", pair));
                        }
                );
    }

    private static void demonstrateScan()
    {
        Observable.fromArray("its", " Fun", "ny works", " all the time")
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(s-> System.out.println(s));
    }



}


