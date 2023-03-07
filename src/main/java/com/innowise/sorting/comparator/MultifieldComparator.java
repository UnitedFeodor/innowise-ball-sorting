package com.innowise.sorting.comparator;

import java.util.Comparator;
import java.util.List;

public interface MultifieldComparator<T>{

    /**
     * Works like compare() from Comparator<T> but doesn't change order
     * of elements specified in @param alreadySortedAttributes.
     * Proposed implementation:
     *              for(BallAttribute attribute : alreadySortedAttributes) {
     *                 int comparisonRes = attribute.compare(o1,o2);
     *                 if (comparisonRes != 0) {
     *                     return comparisonRes;
     *                 }
     *              }
     * if not equal then the order is that result number else we continue
     * @param o1
     * @param o2
     * @param alreadySortedAttributes
     * @return
     * -1 if o1 < o2;
     * 0 if o1 == o2;
     * +1 if o1 > o2;
     */
    int compareMultifield(T o1, T o2, List<Comparator<T>> alreadySortedAttributes);


}
