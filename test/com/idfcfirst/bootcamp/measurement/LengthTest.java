package com.idfcfirst.bootcamp.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {

    @Test
    public void OneKmShouldBeEqualTo1000CentiMeter()
    {
        Length kilometer = Length.KiloMeter(1);
        assertEquals(1000, kilometer.baseValue());
    }

    @Test
    public void TwoKilometerShouldBeEqualToTwoKilometer()
    {
        Length kilometer = Length.KiloMeter(2);
        assertEquals(Length.KiloMeter(2), kilometer);
    }

    @Test
    public void OneCentimeterShouldBeEqualTo1CentiMeter()
    {
        Length centimeter = Length.CentiMeter(1);
        assertEquals(1, centimeter.baseValue());
    }

    @Test
    public void ThousandCentimeterShouldBeEqualTo1KiloMeter() {
        Length centimeter = Length.CentiMeter(1000);
        Length kilometer = Length.KiloMeter(1);
        assertEquals(centimeter, kilometer);
    }

    @Test
    public void Add200CentimeterAnd2Kilometer() {
        Length centimeter = Length.CentiMeter(200);
        Length kilometer = Length.KiloMeter(2);
        Length calculated = centimeter.Add(kilometer);
        assertEquals(Length.CentiMeter(2200), calculated);
    }


    @Test
    public void Add2KilometerAnd200Centimeter() {
        Length centimeter = Length.CentiMeter(200);
        Length kilometer = Length.KiloMeter(2);
        Length calculated = kilometer.Add(centimeter);
        assertEquals(Length.KiloMeter(2.2), calculated);
    }

    @Test
    public void Add2KilometerAnd3Meter() {
        Length centimeter = Length.Meter(3);
        Length kilometer = Length.KiloMeter(2);
        Length calculated = kilometer.Add(centimeter);
        assertEquals(Length.KiloMeter(2.3), calculated);

    }
}
