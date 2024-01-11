package com.idfcfirst.bootcamp.measurement;

import java.util.Objects;

public class Length {
    private static final Unit KILOMETER = new Unit( 100000);
    private static final Unit CENTIMETER = new Unit(1);

    private static final Unit METER = new Unit(100);
    private double value;
    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length kiloMeter(double value) {
        return new Length(value, KILOMETER);
    }

    public static Length centiMeter(double value) {
        return new Length(value, CENTIMETER);
    }

    public static Length meter(double  value) {
        return new Length(value, METER);
    }

    private double baseValue() {return this.unit.ToBaseValue(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return baseValue() == ((Length) o).baseValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Length add(Length length) {
        double baseValue = this.baseValue() + length.baseValue();
        double convertedValue = baseValue / this.unit.baseValue();
        return new Length(convertedValue, this.unit);
    }
}
