package enums;

import balls.AbstractBall;
import interfaces.Sort;

import java.util.Comparator;
import java.util.List;

public enum SortType implements Sort<AbstractBall> {
    HEAP_SORT{
        @Override
        public List<AbstractBall> sort(List<AbstractBall> listToSort, Comparator<AbstractBall> comparator) {
            return null; //TODO implement
        }
    },

    MERGE_SORT {
        @Override
        public List<AbstractBall> sort(List<AbstractBall> listToSort, Comparator<AbstractBall> comparator) {
            return null; //TODO implement
        }
    }
}
