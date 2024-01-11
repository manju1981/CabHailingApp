package com.idfcfirst.bootcamp.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {

    @Test
    public void oneKmShouldBeEqualTo1000CentiMeter()
    {
        Length kilometer = Length.kiloMeter(1);
        assertEquals(Length.centiMeter(100000), kilometer);
    }

    @Test
    public void twoKilometerShouldBeEqualToTwoKilometer()
    {
        Length twoKilometer = Length.kiloMeter(2);
        assertEquals(Length.kiloMeter(2), twoKilometer);
    }

    @Test
    public void oneCentimeterShouldBeEqualTo1CentiMeter()
    {
        Length centimeter = Length.centiMeter(1);
        assertEquals(Length.centiMeter(1), centimeter);
    }

    @Test
    public void thousandCentimeterShouldBeEqualTo1KiloMeter() {
        Length thousandCentimeter = Length.centiMeter(100000);
        Length kilometer = Length.kiloMeter(1);
        assertEquals(thousandCentimeter, kilometer);
    }

    @Test
    public void add200CentimeterAnd2Kilometer() {
        Length twoHundredCentimeter = Length.centiMeter(200);
        Length twoKilometer = Length.kiloMeter(2);
        Length calculated = twoHundredCentimeter.add(twoKilometer);
        assertEquals(Length.centiMeter(200200), calculated);
    }


    @Test
    public void add2KilometerAnd200Centimeter() {
        Length twoHundredcentimeter = Length.centiMeter(200);
        Length kilometer = Length.kiloMeter(2);
        Length calculated = kilometer.add(twoHundredcentimeter);
        assertEquals(Length.kiloMeter(2.002), calculated);
    }

    @Test
    public void add2KilometerAnd3Meter() {
        Length threeMeter = Length.meter(3);
        Length kilometer = Length.kiloMeter(2);
        Length calculated = kilometer.add(threeMeter);
        assertEquals(Length.kiloMeter(2.003), calculated);

    }
}
