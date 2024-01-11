package com.idfcfirst.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot {
    private static final class ParkingLotObservers{
        private final HashSet<ParkingLotObserver> observers = new HashSet<>();
        public void add(ParkingLotObserver observer){
            observers.add(observer);
        }
        public void notifyFull(){
            for (var party : observers) {
                party.notifyFull();
            }
        }

        public void notifySpaceAvailability() {
            for (var party : observers) {
                party.notifySpaceAvailability();
            }
        }
    }

    private final int capacity;
    private final ParkingLotObservers interestedParties = new ParkingLotObservers();
    private final HashMap<Object, Object> parkedCars = new HashMap<>();

    public ParkingLot(int capacity, ParkingLotObserver owner) {
        this.capacity = capacity;
        if (owner != null ) this.interestedParties.add(owner);
    }

    public ParkingLot(int capacity) {
        this(capacity, null);
    }

    public Object park(Object car) throws UnableToParkException {
        if (isFull()) throw UnableToParkException.whenParkingLotIsFull();
        if (parkedCars.containsValue(car)) throw UnableToParkException.whenCarIsAlreadyParked();
        Object token = new Object();
        parkedCars.put(token, car);
        if (isFull()) interestedParties.notifyFull();
        return token;
    }

    private boolean isFull() {
        return parkedCars.size() >= capacity;
    }

    public Object unPark(Object token) throws UnableToUnParkException {
        var wasFull = isFull();
        if (!parkedCars.containsKey(token)) throw UnableToUnParkException.whenTokenIsInvalid();
        Object removed = parkedCars.remove(token);
        if (wasFull) this.interestedParties.notifySpaceAvailability();
        return removed;
    }

    public void addInterestedParty(ParkingLotObserver party) {
        if (party != null){
            interestedParties.add(party);
        }
    }
}
