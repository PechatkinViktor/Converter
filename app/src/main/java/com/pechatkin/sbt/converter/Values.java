package com.pechatkin.sbt.converter;

public enum Values {

    KILOMETRE(R.string.kilometre, 1000,     0.001),
    METRE(R.string.metre, 1, 1),
    MILLIMETRE(R.string.millimetre, 0.001, 1000),
    MILE(R.string.mile, 1609.34, 0.000621371),
    FOOT(R.string.foot, 0.3048,3.28084),

    KILOGRAM(R.string.kilogram, 1, 1),
    MILLIGRAM(R.string.milligram, 0.000001, 1000000),
    GRAM(R.string.gram, 0.001, 1000),
    TON(R.string.ton, 1000, 0.001),
    POUND(R.string.pound, 2.20462, 0.453592);

    public final int mLabelRes;
    public final double mConvertToBase;
    public final double mConvertFromBase;

    Values(int labelRes, double convertToBase, double convertFromBase) {
        mLabelRes = labelRes;
        mConvertToBase = convertToBase;
        mConvertFromBase = convertFromBase;
    }
}
