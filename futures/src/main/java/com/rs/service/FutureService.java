package com.rs.service;

import java.util.concurrent.CompletableFuture;

public class FutureService<T> {
    public CompletableFuture<T> simpleFuture(){
        return new CompletableFuture<>();
    }
}
