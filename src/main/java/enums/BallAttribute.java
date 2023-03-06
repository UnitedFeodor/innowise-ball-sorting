package enums;

import balls.AbstractBall;
import interfaces.MultifieldComparator;

import java.util.Comparator;
import java.util.List;

public enum BallAttribute implements MultifieldComparator<AbstractBall,BallAttribute>,Comparator<AbstractBall> {
    CLASS {
        @Override
        public int compare(AbstractBall o1, AbstractBall o2) {
            Class<? extends AbstractBall> class1 = o1.getClass();
            Class<? extends AbstractBall> class2 = o2.getClass();
            return class1.getSimpleName().compareTo(class2.getSimpleName());
        }
    }, MASS{
        @Override
        public int compare(AbstractBall o1, AbstractBall o2) {
            int mass1 = o1.getMassG();
            int mass2 = o2.getMassG();
            return mass1-mass2;
        }
    }, CIRCUMFERENCE {
        @Override
        public int compare(AbstractBall o1, AbstractBall o2) {
            int diameter1 = o1.getCircumferenceMM();
            int diameter2 = o2.getCircumferenceMM();
            return diameter1-diameter2;
        }
    }, COLOR {
        @Override
        public int compare(AbstractBall o1, AbstractBall o2) {
            Color color1 = o1.getColor();
            Color color2 = o2.getColor();
            return color1.compareTo(color2);
        }
    };

    private static int checkSortedAttributesForOrder(AbstractBall o1, AbstractBall o2, List<BallAttribute> alreadySortedAttributes) {
        int comparisonRes = 0;
        for(BallAttribute attribute : alreadySortedAttributes) {
            comparisonRes = attribute.compare(o1, o2);
            if (comparisonRes != 0) {
                return comparisonRes;
            }
        }
        return comparisonRes;
    }

    @Override
    public int compareMultifield(AbstractBall o1, AbstractBall o2, List<BallAttribute> alreadySortedAttributes) {
        int comparisonRes = checkSortedAttributesForOrder(o1, o2, alreadySortedAttributes);
        if (comparisonRes != 0) { // they are already sorted
            return comparisonRes;
        } else {
            return compare(o1,o2);
        }
    }
}
