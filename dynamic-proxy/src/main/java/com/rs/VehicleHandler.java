package com.rs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicleHandler implements InvocationHandler {

    private Vehicle vehicle;

    public VehicleHandler(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(vehicle, args);
    }
}
