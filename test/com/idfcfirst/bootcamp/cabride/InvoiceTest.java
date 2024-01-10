package com.idfcfirst.bootcamp.cabride;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceTest {
    @Test
    public void invoiceShouldHaveTotalFareOfZeroWhenThereAreNoRides(){
        assertEquals(0, new Invoice().totalFare());
    }
    @Test
    public void invoiceShouldHaveTotalFareOf62WhenThereIsOneRide(){
        Invoice invoice = new Invoice();
        invoice.add(new CabRide(5,6));
        assertEquals(62, invoice.totalFare());
    }

    @Test
    public void invoiceShouldHaveTotalFareOf142ForTwoCabRides() {
        Invoice invoice = new Invoice();
        invoice.add(new CabRide(5,6));
        invoice.add(new CabRide(8,0));
        assertEquals(142, invoice.totalFare());
    }
    @Test
    public void invoiceShouldRegisterNumberOfRides() {
        Invoice invoice = new Invoice();
        invoice.add(new CabRide(5,6));
        invoice.add(new CabRide(8,0));
        assertEquals(2, invoice.numberOfRides());
    }

    @Test
    public void invoiceShouldProvideAverageFare() {
        Invoice invoice = new Invoice();
        invoice.add(new CabRide(5,6));
        invoice.add(new CabRide(8,0));
        assertEquals(71, invoice.averageFare());
    }
    @Test
    public void invoiceShouldProvideAverageFareWhenThereAreNoRides() {
        Invoice invoice = new Invoice();
        assertEquals(0, invoice.averageFare());
    }
}
