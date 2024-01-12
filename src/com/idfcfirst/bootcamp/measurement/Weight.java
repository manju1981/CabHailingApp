package com.idfcfirst.bootcamp.measurement;


public class Weight extends Measurement<Weight>{
    private static final Unit MILLIGRAM = new Unit( 1,0);
    private static final Unit GRAM = new Unit(1000,0);

    private static final Unit KILOGRAM = new Unit(1000000,0);
    private Weight(double value, Unit unit) {
       super(value, unit);
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

    @Override
    public Weight create(double value, Unit unit) {
        return new Weight(value, unit);
    }



}
