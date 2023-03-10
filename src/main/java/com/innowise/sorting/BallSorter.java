package com.innowise.sorting;

import com.innowise.ball.AbstractBall;
import com.innowise.sorting.algorithm.Sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BallSorter<T extends AbstractBall> {
    private final List<Comparator<T>> sortingAttributeComparators = new ArrayList<>();
    private Sorter<T> sortingAlgorithm;

    private boolean ascendingOrder = true;
 
    public BallSorter(Sorter<T> sortingAlgorithm) {
        if (sortingAlgorithm == null) {
            throw new IllegalArgumentException("sortingAlgorithm can't be null");
        }
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public BallSorter<T> setSortingAlgorithm(Sorter<T> sortingAlgorithm) {
        if (sortingAlgorithm == null) {
            throw new IllegalArgumentException("sortingAlgorithm can't be null");
        }
        this.sortingAlgorithm = sortingAlgorithm;
        return this;
    }
    public Sorter<T> getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public BallSorter<T> addSortingAttribute(Comparator<T> attributeComparator) {
        if (!sortingAttributeComparators.contains(attributeComparator)) {
            sortingAttributeComparators.add(attributeComparator);
        }
        return this;
    }
    public List<Comparator<T>> getSortingAttributeComparators() {
        return Collections.unmodifiableList(sortingAttributeComparators);
    }

    public BallSorter<T> clearSortingAttributes() {
        sortingAttributeComparators.clear();
        return this;
    }

    public boolean isAscendingOrder() {
        return ascendingOrder;
    }

    public void setAscendingOrder(boolean ascendingOrder) {
        this.ascendingOrder = ascendingOrder;
    }

    /**
     * Sorts by the attributes provided to the class, mutates the initial list
     * @param ballsToSort - the list to sort and the resulting sorted list
     * @return the modified list
     */
    public List<T> sortBallsByAttributes(List<T> ballsToSort) {
        if (ballsToSort == null) {
            throw new IllegalArgumentException("ballsToSort can't be null");
        }
        if (ballsToSort.isEmpty()) {
            throw new IllegalArgumentException("ballsToSort can't be empty");
        }
        if (sortingAttributeComparators.isEmpty()) {
            return ballsToSort;
        }

        List<Comparator<T>> alreadySortedAttributes = new ArrayList<>();
        for(Comparator<T> currAttributeComparator : sortingAttributeComparators) {
            Comparator<T> multifieldComparator = getMultifieldComparatorForAttribute(currAttributeComparator,alreadySortedAttributes);
            sortingAlgorithm.sort(ballsToSort,multifieldComparator);
            alreadySortedAttributes.add(currAttributeComparator);

        }
        return ballsToSort;
    }

    private Comparator<T> getMultifieldComparatorForAttribute(Comparator<T> attributeComparator, List<Comparator<T>> alreadySortedAttributes) {
        return new Comparator<>() {
            private int checkSortedAttributesForOrder(T o1, T o2, List<Comparator<T>> alreadySortedAttributes) {
                int comparisonRes = 0;
                for (var attribute : alreadySortedAttributes) {
                    comparisonRes = attribute.compare(o1, o2);
                    if (comparisonRes != 0) {
                        return comparisonRes;
                    }
                }
                return comparisonRes;
            }

            @Override
            public int compare(T o1, T o2) {
                if (!ascendingOrder) { // swap the objects to reverse all comparisons
                    T temp = o1;
                    o1 = o2;
                    o2 = temp;
                }
                int comparisonRes = checkSortedAttributesForOrder(o1, o2, alreadySortedAttributes);
                if (comparisonRes != 0) { // they are already sorted
                    return comparisonRes;
                } else {
                    return attributeComparator.compare(o1, o2);
                }
            }
        };
    }

}
