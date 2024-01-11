package com.idfcfirst.bootcamp.measurement;


public class Length  extends Measurement<Length>{
    private static final Unit KILOMETER = new LengthUnit( 100000);
    private static final Unit CENTIMETER = new LengthUnit(1);

    private static final Unit METER = new LengthUnit(100);

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



    private static class LengthUnit extends Unit {
        public LengthUnit(int baseValue) {
            super(baseValue);
        }
    }
}
