package com.idfcfirst.bootcamp.cabride;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabRideTest {
    @Test
    public void fareShouldBe40WhenTheDistanceTravelledIs4KM(){
        assertEquals(40, new CabRide(4, 0).Fare());
    }
    @Test
    public void fareShouldBe60WhenTheDistanceTravelledIs6KM(){
        assertEquals(60, new CabRide(6, 0).Fare());
    }

    @Test
    public void fareShouldBe56WhenDistanceTravelledIs5KmAndWaitingTimeIs3min() {
        assertEquals(56, new CabRide(5,3).Fare());
    }
}
