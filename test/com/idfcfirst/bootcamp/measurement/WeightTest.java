package com.idfcfirst.bootcamp.measurement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightTest {

    @Test
    public void oneKilogramShouldBeEqualTo1000gram()
    {
        Weight kilogram = Weight.kilogram(1);
        assertEquals(Weight.gram(1000), kilogram);
    }

    @Test
    public void oneKilogramShouldBeEqualTo1000000milligram()
    {
        Weight kilogram = Weight.kilogram(1);
        assertEquals(Weight.milligram(1000000), kilogram);
    }

    @Test
    public void twoKilogramShouldBeEqualToTwoKilogram()
    {
        Weight twoKilogram = Weight.kilogram(2);
        assertEquals(Weight.kilogram(2), twoKilogram);
    }


    @Test
    public void thousandGramShouldBeEqualTo1Kilogram() {
        Weight thousandGram = Weight.gram(1000);
        Weight kilogram = Weight.kilogram(1);
        assertEquals(thousandGram, kilogram);
    }

    @Test
    public void add200gramsAnd2Kilogram() {
        Weight twoHundredGram = Weight.gram(200);
        Weight twoKilogram = Weight.kilogram(2);
        Weight calculated = twoHundredGram.add(twoKilogram);
        assertEquals(Weight.gram(2200), calculated);
    }


    @Test
    public void add2KilogramAnd200gram() {
        Weight twoHundredGram = Weight.gram(200);
        Weight kilogram = Weight.kilogram(2);
        Weight calculated = kilogram.add(twoHundredGram);
        assertEquals(Weight.kilogram(2.2), calculated);
    }

    @Test
    public void add2KilometerAnd300milligram() {
        Weight threeHundredMilligram = Weight.milligram(300);
        Weight kilogram = Weight.kilogram(2);
        Weight calculated = kilogram.add(threeHundredMilligram);
        assertEquals(Weight.kilogram(2.0003), calculated);
    }

}
