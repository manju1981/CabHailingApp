package com.idfcfirst.bootcamp.measurement;

import java.util.Objects;

public class Weight {
    private static final Unit MILLIGRAM = new Unit( 1);
    private static final Unit GRAM = new Unit(1000);

    private static final Unit KILOGRAM = new Unit(1000000);
    private double value;
    private final Unit unit;

    private Weight(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Weight kilogram(double value) {
        return new Weight(value, KILOGRAM);
    }

    public static Weight milligram(double value) {
        return new Weight(value, MILLIGRAM);
    }

    public static Weight gram(double  value) {
        return new Weight(value, GRAM);
    }

    public double baseValue() {return this.unit.ToBaseValue(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return baseValue() == ((Weight) o).baseValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Weight add(Weight weight) {
        double baseValue = this.baseValue() + weight.baseValue();
        double convertedValue = baseValue / this.unit.baseValue();
        return new Weight(convertedValue, this.unit);
    }
}
