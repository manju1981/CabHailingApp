package com.idfcfirst.bootcamp.parkinglot;

public class UnableToParkException extends Exception{
    private UnableToParkException(String message) {
        super(message);
    }

    static UnableToParkException whenParkingLotIsFull() {
        return new UnableToParkException("Parking lot is full");
    }

    public static UnableToParkException whenCarIsAlreadyParked() {
        return new UnableToParkException("Cannot park the same car twice");
    }
}
