package com.innowise.sorting.algorithm;

import com.innowise.sorting.comparator.MultifieldComparator;

import java.util.Comparator;
import java.util.List;

public interface MultifieldSort<T> {

    /**
     * Sorts the list of entities provided (mutating it) taking into account the other already sorted attributes
     * decided by the list of comparators in alreadySortedAttributes
     * @param listToSort - list to be sorted, modified in process
     * @param comparator - a multifield comparator impl(use in place of >,<,= etc.)
     *                   that makes sure already sorted attributes are taken into account
     * @param alreadySortedAttributes - already sorted attributes
     */
    void sortMultifield(List<T> listToSort, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes);

}
