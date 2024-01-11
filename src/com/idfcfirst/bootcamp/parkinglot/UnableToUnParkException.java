package com.idfcfirst.bootcamp.parkinglot;

public class UnableToUnParkException extends Exception{
    private UnableToUnParkException(String reason) {
        super(reason);
    }

    static UnableToUnParkException whenTokenIsInvalid() {
        return new UnableToUnParkException("Invalid token");
    }
}
