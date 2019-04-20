package com.rs.utils;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    public List<Integer> generate(int limit){
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(limit)
                .map(n -> n[0])
                .collect(toList());
    }
}