package com.idfcfirst.bootcamp.cabride;

public class Invoice {
    private int totalFare;
    private int numberOfRides;

    public int totalFare() {
        return totalFare;
    }

    public void add(CabRide cabRide) {
        this.totalFare += cabRide.Fare();
        this.numberOfRides += 1;
    }

    public int numberOfRides() {
        return this.numberOfRides;
    }

    public int averageFare() {
        return numberOfRides > 0 ? totalFare/numberOfRides : 0;
    }
}
