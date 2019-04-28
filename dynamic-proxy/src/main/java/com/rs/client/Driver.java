package com.rs.client;

import com.rs.Car;
import com.rs.Vehicle;
import com.rs.VehicleHandler;

import java.lang.reflect.Proxy;

public class Driver {

    public static void main(String[] args) {
        Vehicle v = new Car("Nano");
        ClassLoader c = Vehicle.class.getClassLoader();
        Vehicle proxyVehicle = (Vehicle) Proxy.newProxyInstance(c,new Class[]{Vehicle.class}, new VehicleHandler(v));

        proxyVehicle.start();
        proxyVehicle.stop();
    }
}
