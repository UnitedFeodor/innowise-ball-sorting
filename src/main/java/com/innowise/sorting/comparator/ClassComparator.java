package com.innowise.sorting.comparator;

import com.innowise.ball.AbstractBall;

import java.util.Comparator;

public class ClassComparator<T extends AbstractBall> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Class<?> class1 = o1.getClass();
        Class<?> class2 = o2.getClass();
        return class1.getSimpleName().compareTo(class2.getSimpleName());
    }
}
