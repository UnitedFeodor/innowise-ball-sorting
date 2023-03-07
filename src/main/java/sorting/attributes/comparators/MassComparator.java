package sorting.attributes.comparators;

import balls.AbstractBall;

import java.util.Comparator;

public class MassComparator<T extends AbstractBall> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int mass1 = o1.getMassG();
        int mass2 = o2.getMassG();
        return mass1-mass2;
    }
}
