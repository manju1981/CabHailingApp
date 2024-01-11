package com.idfcfirst.bootcamp.parkinglot;

public interface ParkingLotObserver {
    void notifyFull();

    void notifySpaceAvailability();
}
