package com.tpe.exception;

public class ShoesAlreadyAdded extends RuntimeException {
    public ShoesAlreadyAdded(String message) {
        super(message);
    }
}
