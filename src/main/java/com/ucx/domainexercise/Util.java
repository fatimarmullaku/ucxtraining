package com.ucx.domainexercise;

public class Util {

    public Integer sum(Integer a, Integer b){
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return a+b;
    }
}
