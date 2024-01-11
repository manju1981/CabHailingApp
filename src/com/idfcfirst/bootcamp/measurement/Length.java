package com.idfcfirst.bootcamp.measurement;

import java.util.Objects;

public class Length {
    private static final Unit KILOMETER = new Unit( 1000);
    private static final Unit CENTIMETER = new Unit(1);

    private static final Unit METER = new Unit(100);
    private double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length KiloMeter(double value) {
        return new Length(value, KILOMETER);
    }

    public static Length CentiMeter(double value) {
        return new Length(value, CENTIMETER);
    }

    public static Length Meter(double  value) {
        return new Length(value, METER);
    }

    public double baseValue() {return this.unit.ToBaseValue(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return baseValue() == ((Length) o).baseValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Length Add(Length kilometer) {
        double baseValue = this.baseValue() + kilometer.baseValue();
        double convertedValue = baseValue / this.unit.baseValue();
        return new Length(convertedValue, this.unit);
    }
}
