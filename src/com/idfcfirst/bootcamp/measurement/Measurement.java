package com.idfcfirst.bootcamp.measurement;

import java.util.Objects;

public abstract class Measurement<T>  {
    private final Unit unit;
    private final double value;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double baseValue() {return this.unit.ToBaseValue(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return Math.abs(baseValue() - ((Measurement<Object>) o).baseValue())<=0.005;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public abstract T create(double value, Unit unit);
    public T add(Measurement<T> t) throws UnsupportedOperationException{
        double baseValue = this.baseValue() + t.baseValue();
        double convertedValue = baseValue / this.unit.baseValue();
        return this.create(convertedValue, this.unit);
    }

}
