package sorting;

import balls.AbstractBall;
import sorting.interfaces.MultifieldComparator;
import sorting.interfaces.MultifieldSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BallSorter<T extends AbstractBall> {
    private final List<Comparator<T>> sortingAttributeComparators = new ArrayList<>();
    private MultifieldSort<T> sortingAlgorithm;
 
    public BallSorter(MultifieldSort<T> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public BallSorter setSortingAlgorithm(MultifieldSort<T> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
        return this;
    }
    public MultifieldSort<T> getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public BallSorter addSortingAttribute(Comparator<T> attributeComparator) {
        if (!sortingAttributeComparators.contains(attributeComparator)) {
            sortingAttributeComparators.add(attributeComparator);
        }
        return this;
    }
    public List<Comparator<T>> getSortingAttributeComparators() {
        return Collections.unmodifiableList(sortingAttributeComparators);
    }

    public BallSorter clearSortingAttributes() {
        sortingAttributeComparators.clear();
        return this;
    }

    /**
     * Sorts by the attributes provided to the class, mutates the initial list
     * @param ballsToSort - the list to sort and the resulting sorted list
     * @return the modified list
     */
    public List<T> sortBallsByAttributes(List<T> ballsToSort) {
        if (ballsToSort == null) {
            throw new NullPointerException("ballsToSort can't be null");
        }
        if (ballsToSort.isEmpty()) {
            throw new IllegalArgumentException("ballsToSort can't be empty");
        }
        if (sortingAttributeComparators.isEmpty()) {
            return ballsToSort;
        }

        /*
        List<T> listCopy = new ArrayList<>();
        for(var ball : ballsToSort) {
            listCopy.add(ball.clone());
        }*/
        List<Comparator<T>> alreadySortedAttributes = new ArrayList<>();
        for(Comparator<T> attributeComparator : sortingAttributeComparators) {
            MultifieldComparator<T> multifieldComparator = getMultifieldComparatorForAttribute(attributeComparator);
            sortingAlgorithm.sortMultifield(ballsToSort,multifieldComparator,alreadySortedAttributes);
            alreadySortedAttributes.add(attributeComparator);

            // TODO remove debug
            System.out.println("during sort: "+ballsToSort);
        }
        return ballsToSort;
    }

    private MultifieldComparator<T> getMultifieldComparatorForAttribute(Comparator<T> attributeComparator) {
        return new MultifieldComparator<T>() {
            private int checkSortedAttributesForOrder(T o1, T o2, List<Comparator<T>> alreadySortedAttributes) {
                int comparisonRes = 0;
                for(var attribute : alreadySortedAttributes) {
                    comparisonRes = attribute.compare(o1, o2);
                    if (comparisonRes != 0) {
                        return comparisonRes;
                    }
                }
                return comparisonRes;
            }
            @Override
            public int compareMultifield(T o1, T o2, List<Comparator<T>> alreadySortedAttributes) {
                int comparisonRes = checkSortedAttributesForOrder(o1, o2, alreadySortedAttributes);
                if (comparisonRes != 0) { // they are already sorted
                    return comparisonRes;
                } else {
                    return attributeComparator.compare(o1,o2);
                }
            }
        };
    }

}
