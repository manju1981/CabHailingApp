package com.idfcfirst.bootcamp.measurement;

public abstract class Unit {
    private final int baseValue;

    public Unit(int baseValue) {
        this.baseValue = baseValue;
    }

    public double ToBaseValue(double value) {
        return this.baseValue * value;
    }

    public int baseValue() {
        return baseValue;
    }
}
