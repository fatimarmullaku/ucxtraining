package com.ucx.domainexercise.repository;

public class DuplicateFoundException extends Exception {

    public DuplicateFoundException(String message) {
        super(message);
    }
}
