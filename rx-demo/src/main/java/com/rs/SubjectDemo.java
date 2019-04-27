package com.rs;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SubjectDemo {

    public static void main(String[] args) {
        publishSubject();
        behaviourSubject();
        replaySubject();
        asyncSubject();
        try {
            unicastSubject();
        }
        catch(Exception e){
            System.out.println("Interrupted... probably!");
            e.printStackTrace();
        }
    }

    public static void publishSubject() {
        Subject<String> subject = PublishSubject.create();

        subject.subscribe(System.out::print);

        subject.onNext("Publish Subjects ");
        subject.onNext("are ");
        subject.onNext("cool");

        subject.onComplete();
    }

    public static void behaviourSubject() {
        Subject<String> subject = BehaviorSubject.create();

        subject.subscribe(System.out::print);

        subject.onNext("Behavior Subjects ");
        subject.onNext("are ");
        subject.onNext("cool");
        subject.onNext("too");

        //new subscribe gets last emission replayed
        subject.subscribe(System.out::println);
        subject.onComplete();
    }

    public static void replaySubject() {
        Subject<String> subject = ReplaySubject.create();
        subject.subscribe(System.out::println);
        subject.onNext("Replay subjects ensure that things are cached and the subscription done below gets this message");
        subject.subscribe(System.out::println);
        subject.onComplete();
    }

    public static void asyncSubject() {
        //This is similar to takeLast(1).replay(1)
        Subject<String> subject = AsyncSubject.create();
        subject.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Complete"));
        subject.onNext("If you want this - comment the two onNext()s below");
        subject.onNext("If you want this - comment the onNext() below");
        subject.onNext("Else live with me :) thanks Async Subject");
        subject.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Complete"));
        subject.onComplete();

        /* // The below code didnt work as expected :|
        ConnectableObservable<String> co = Observable.just("One", "Two"," Three").publish();

        co.subscribe(System.out::println,Throwable::printStackTrace, ()-> System.out.println("Observer 1 Complete"));
        co.takeLast(1).replay(1);
        co.connect();
        co.subscribe(System.out::println,Throwable::printStackTrace, ()-> System.out.println("Observer 2 Complete"));*/

    }

    public static void unicastSubject() throws InterruptedException {
        Subject<String> subject = UnicastSubject.create();
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds")
                .subscribe(subject);
        sleep(2000);
        subject.subscribe(s -> System.out.println("Observer 1: " + s));

        //I was wondering what the below sleep is for - it was so that main daemon dosent die!
        sleep(2000);


        /*
            When you run this code, you will see that after 2 seconds, the first six emissions are released immediately to the Observer when it subscribes. Then, it will receive live emissions from that point on.
            Important:
            There is one important property of UnicastSubject; it will only work with one Observer and will throw an error for any subsequent ones.
            Logically, this makes sense because it is designed to release buffered emissions from its internal queue once it gets an Observer.
            But when these cached emissions are released, they cannot be released again to a second Observer since they are already gone.
         */
    }

}
