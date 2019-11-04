package com.pechatkin.sbt.converter;

import java.util.Arrays;
import java.util.List;

public enum Conversion {
    LENGTH(R.string.length, Arrays.asList(Values.METRE, Values.KILOMETRE, Values.MILLIMETRE, Values.FOOT, Values.MILE)),
    WEIGHT(R.string.weight, Arrays.asList(Values.KILOGRAM, Values.MILLIGRAM, Values.GRAM, Values.POUND, Values.TON)),
    AREA(R.string.area, WEIGHT.mValuesList),
    VOLUME(R.string.volume, WEIGHT.mValuesList),
    TEMPERATURE(R.string.temperature, WEIGHT.mValuesList),
    DENSITY(R.string.density, WEIGHT.mValuesList),
    FREQUENCY(R.string.frequency, WEIGHT.mValuesList),
    ENERGY(R.string.energy, WEIGHT.mValuesList),
    DATA_RATE(R.string.data_rate, WEIGHT.mValuesList),
    PRESSURE(R.string.pressure, WEIGHT.mValuesList),
    FUEL_CONSUMPTION(R.string.fuel_consumption, WEIGHT.mValuesList),
    VOLUME_INFO(R.string.volume_info, WEIGHT.mValuesList);


    public final int mLabelRes;
    public final List<Values> mValuesList;

    Conversion(int labelRes, List<Values> valuesList) {
        mLabelRes = labelRes;
        mValuesList = valuesList;
    }
}
