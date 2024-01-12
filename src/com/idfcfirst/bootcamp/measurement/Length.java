package com.idfcfirst.bootcamp.measurement;


public class Length  extends Measurement<Length>{
    private static final Unit KILOMETER = new Unit( 100000, 0);
    private static final Unit CENTIMETER = new Unit(1,0);

    private static final Unit METER = new Unit(100, 0);

    private Length(double value, Unit unit) {
        super(value, unit);
    }

    @Override
    public Length create(double value, Unit unit) {
        return new Length(value, unit);
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


}
