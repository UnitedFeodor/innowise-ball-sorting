package sorting.attributes.comparators;

import balls.AbstractBall;
import balls.enums.Color;

import java.util.Comparator;

public class ColorComparator<T extends AbstractBall> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Color color1 = o1.getColor();
        Color color2 = o2.getColor();
        return color1.compareTo(color2);
    }
}
