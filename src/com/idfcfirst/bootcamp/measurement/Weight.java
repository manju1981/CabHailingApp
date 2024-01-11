package com.idfcfirst.bootcamp.measurement;


public class Weight extends Measurement<Weight>{
    private static final WeightUnit MILLIGRAM = new WeightUnit( 1);
    private static final WeightUnit GRAM = new WeightUnit(1000);

    private static final WeightUnit KILOGRAM = new WeightUnit(1000000);
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


    private static class WeightUnit extends  Unit{

        public WeightUnit(int baseValue) {
            super(baseValue);
        }
    }
}
