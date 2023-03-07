package com.innowise.sorting.comparator;

import com.innowise.ball.GolfBall;

import java.util.Comparator;

public class DimpleAmountComparator<T extends GolfBall> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int dimpleAmount1 = o1.getDimpleAmount();
        int dimpleAmount2 = o2.getDimpleAmount();
        return dimpleAmount1-dimpleAmount2;
    }
}