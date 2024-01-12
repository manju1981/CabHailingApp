package com.idfcfirst.bootcamp.measurement;

public class Unit {
    private final double baseValue;
    private double offset;

    public Unit(double baseValue, double offset) {
        this.baseValue = baseValue;
        this.offset = offset;
    }

    public double ToBaseValue(double value) {
        return this.baseValue * value + offset;
    }

    public double baseValue() {
        return baseValue;
    }
}
