package com.idfcfirst.bootcamp.cabride;

public class CabRide {

    public static final int FARE_PER_KILOMETER = 10;
    public static final int WAITING_CHARGE_PER_MINUTE = 2;
    public static final int MINIMUM_FARE = 40;
    private final int distance;
    private final int waitingTime;

    public CabRide(int distance, int waitingTime) {

        this.distance = distance;
        this.waitingTime = waitingTime;
    }

    public int Fare(){
        int totalDistanceFare = this.distance * FARE_PER_KILOMETER;
        int totalWaitingCharge = this.waitingTime * WAITING_CHARGE_PER_MINUTE;
        int totalFare = totalDistanceFare + totalWaitingCharge;

        return Math.max(totalFare, MINIMUM_FARE);
    }
}
