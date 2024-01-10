package com.idfcfirst.bootcamp.cabride;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabRideTest {
    @Test
    public void fareShouldBe50WhenTheDistanceTravelledIs5KM(){
        assertEquals(50, new CabRide(5, 0).Fare());
    }
    @Test
    public void fareShouldBe60WhenTheDistanceTravelledIs6KM(){
        assertEquals(60, new CabRide(6, 0).Fare());
    }

    @Test
    public void fareShouldBe70WhenDistanceTravelledIs6KmAndWaitingTimeIs5min() {
        assertEquals(70, new CabRide(6,5).Fare());
    }
}
