package com.innowise.sorting.comparator;

import com.innowise.ball.AbstractBall;

import java.util.Comparator;

public class CircumferenceComparator<T extends AbstractBall> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int diameter1 = o1.getCircumferenceMM();
        int diameter2 = o2.getCircumferenceMM();
        return diameter1-diameter2;
    }
}
