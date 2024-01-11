package com.idfcfirst.bootcamp.parkinglot;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Parking Lot")
public class ParkingLotTest {

    @Test
    @DisplayName("should allow cars to be parked when there is space in the lot")
    void shouldAllowCarsToBeParkedWhenThereIsSpaceInTheLot() {
        ParkingLot parkinglot = new ParkingLot(1);
        Object car = new Object();
        assertDoesNotThrow(() -> parkinglot.park(car));
    }

    @Test
    @DisplayName("should not allow cars to be parked when the lot is full")
    void shouldNotAllowCarsToBeParkedWhenTheLotIsFull() {
        ParkingLot parkinglot = new ParkingLot(1);
        Object car1 = new Object();
        Object car2 = new Object();
        assertDoesNotThrow(() -> parkinglot.park(car1));
        var e = assertThrows(UnableToParkException.class, () ->parkinglot.park(car2));
        assertEquals("Parking lot is full", e.getMessage());
    }

    @Test
    @DisplayName("should not allow the car to be parked if it is already parked")
    void shouldNotAllowTheCarToBeParkedIfItIsAlreadyParked() {
        ParkingLot parkinglot = new ParkingLot(2);
        Object car = new Object();
        assertDoesNotThrow(() -> parkinglot.park(car));
        var e = assertThrows(UnableToParkException.class, () ->parkinglot.park(car));
        assertEquals("Cannot park the same car twice", e.getMessage());
    }

    @Test
    @DisplayName("should allow to unpark the car")
    void shouldAllowToUnparkTheCar() throws Exception {
        ParkingLot parkinglot = new ParkingLot(1);
        var  car = new Object();
        var token = parkinglot.park(car);
        assertEquals(car, parkinglot.unPark(token));
    }

    @Test
    @DisplayName("should not allow to un-park the car if the token is not issued by the lot")
    void shouldNotAllowToUnParkTheCarIfTheTokenIsNotIssuedByTheLot() throws UnableToParkException {
        ParkingLot parkinglot = new ParkingLot(1);
        var  car = new Object();
        parkinglot.park(car);
        var e = assertThrows(UnableToUnParkException.class, () ->parkinglot.unPark(car));
        assertEquals("Invalid token", e.getMessage());
    }

    @Test
    @DisplayName("should not allow the user to un-park the car twice")
    void shouldNotAllowTheUserToUnParkTheCarTwice() throws Exception {
        ParkingLot parkinglot = new ParkingLot(1);
        var  car = new Object();
        var token = parkinglot.park(car);
        assertEquals(car, parkinglot.unPark(token));
        var e = assertThrows(UnableToUnParkException.class, () ->parkinglot.unPark(token));
        assertEquals("Invalid token", e.getMessage());
    }

    @Test
    @DisplayName("should inform owner when parking lot is full")
    void shouldInformOwnerWhenParkingLotIsFull() throws UnableToParkException {
        var owner = new TestInterestedParty();
        ParkingLot parkinglot = new ParkingLot(1, owner);
        var  car = new Object();
        parkinglot.park(car);

        assertTrue(owner.notifyFullWasCalled);
    }

    @Test
    @DisplayName("should inform traffic cop when the parking lot is full")
    void shouldInformTrafficCopWhenTheParkingLotIsFull() throws UnableToParkException {
        var cop = new TestInterestedParty();
        ParkingLot parkinglot = new ParkingLot(1);
        parkinglot.addInterestedParty(cop);


        var  car = new Object();
        parkinglot.park(car);

        assertTrue(cop.notifyFullWasCalled);
    }

    @Test
    @DisplayName("should inform owner and cops when the parking space becomes available")
    void shouldInformOwnerAndCopsWhenTheParkingSpaceBecomesAvailable() throws Exception {
        var cop = new TestInterestedParty();
        var owner = new TestInterestedParty();
        ParkingLot parkinglot = new ParkingLot(1, owner);
        parkinglot.addInterestedParty(cop);

        var  car = new Object();
        var token = parkinglot.park(car);

        assertTrue(cop.notifyFullWasCalled);
        assertTrue(owner.notifyFullWasCalled);
        parkinglot.unPark(token);

        assertTrue(cop.notifySpaceAvailableWasCalled);
        assertTrue(owner.notifySpaceAvailableWasCalled);
    }

    @Test
    @DisplayName("should notify space availability only when the space becomes available after becoming full")
    void shouldNotifySpaceAvailabilityOnlyWhenTheSpaceBecomesAvailableAfterBecomingFull() throws Exception {
        var cop = new TestInterestedParty();
        var owner = new TestInterestedParty();
        ParkingLot parkinglot = new ParkingLot(2, owner);
        parkinglot.addInterestedParty(cop);

        var  car = new Object();
        var token = parkinglot.park(car);

        parkinglot.unPark(token);

        assertFalse(cop.notifySpaceAvailableWasCalled);
        assertFalse(owner.notifySpaceAvailableWasCalled);

    }

    private static final class TestInterestedParty implements ParkingLotObserver{
        public boolean notifyFullWasCalled = false;
        public boolean notifySpaceAvailableWasCalled;

        @Override
        public void notifyFull() {
            notifyFullWasCalled = true;
        }

        @Override
        public void notifySpaceAvailability() {
            this.notifySpaceAvailableWasCalled = true;
        }
    }
}
