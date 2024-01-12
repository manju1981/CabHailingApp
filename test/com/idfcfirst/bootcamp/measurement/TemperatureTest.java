package com.idfcfirst.bootcamp.measurement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {
    
    @Test
    @DisplayName("Zero Celcius should be equal to 273.15 kelvin")
    void zeroCelciusShouldBeEqualTo27315Kelvin() {
        assertEquals(Temperature.celcius(0),Temperature.kelvin(273.15));
    }
    
    @Test
    @DisplayName("Zero celcius should be equal to 32 farhenheit")
    void zeroCelciusShouldBeEqualTo32Farhenheit() {
        assertEquals(Temperature.celcius(0),Temperature.farhenheit(32));
    }

    @Test
    @DisplayName("1 Celcius should be equal to 274.15 kelvin")
    void oneCelciusShouldBeEqualTo27415Kelvin() {
        assertEquals(Temperature.celcius(1),Temperature.kelvin(274.15));
    }

    @Test
    @DisplayName("2 celcius should be equal to 35.6 farhenheit")
    void twoCelciusShouldBeEqualTo35point6Farhenheit() {
        assertEquals(Temperature.celcius(2),Temperature.farhenheit(35.6));
    }

    @Test
    @DisplayName("two farhenheit should be equal to 256.483 kelvin farhenheit")
    void twofarhenheitShouldBeEqualTo256_483Kelvin() {
        assertEquals(Temperature.farhenheit(2),Temperature.kelvin(256.483));
    }
    
    @Test
    @DisplayName("two farhenheit shoule be equal to minus 16.667 celcius")
    void twoFarhenheitShouleBeEqualToMinus16667Celcius() {
        assertEquals(Temperature.farhenheit(2),Temperature.celcius(-16.667));
    }
    @Test()
    @DisplayName("throws exception if temperates are added")
    void throwsExceptionIfTemperatesAreAdded() {
        assertThrows(UnsupportedOperationException.class, ()->Temperature.celcius(1).add(Temperature.celcius(1)));
    }
}
