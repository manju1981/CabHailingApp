package com.idfcfirst.bootcamp.measurement;

import java.util.Objects;

public class Temperature extends Measurement<Temperature> {

    private static final Unit CELCIUS = new Unit( 1.8,32);
    private static final Unit KELVIN = new Unit(1.8,-459.67);
    private static final Unit FARHENHEIT = new Unit(1,0);

    public static Temperature celcius(double  value) {
        return new Temperature(value, CELCIUS);
    }
    public static Temperature kelvin(double  value) {
        return new Temperature(value, KELVIN);
    }
    public static Temperature farhenheit(double  value) {
        return new Temperature(value, FARHENHEIT);
    }

    private Temperature(double value, Unit unit) {
        super(value, unit);
    }

    @Override
    public Temperature create(double value, Unit unit) {
        return new Temperature(value, unit);
    }

    @Override
    public Temperature add(Measurement<Temperature> t) {
        throw new UnsupportedOperationException("Temperatures cannot be added");
    }
}
