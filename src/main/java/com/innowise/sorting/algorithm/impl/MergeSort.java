package com.innowise.sorting.algorithm.impl;

import com.innowise.sorting.algorithm.MultifieldSort;
import com.innowise.sorting.comparator.MultifieldComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements MultifieldSort<T> {
    @Override
    public void sortMultifield(List<T> list, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes){
        int size = list.size();
        // last sublist
        if (size < 2){
            return;
        }
        // each iteration divides it into two halves
        int half = size / 2;
        List<T> L1 = new ArrayList<T>(list.subList(0, half));
        List<T> L2 = new ArrayList<T>(list.subList(half,size));

        // recursively sorting each sublist
        sortMultifield(L1, comparator, alreadySortedAttributes);
        sortMultifield(L2, comparator, alreadySortedAttributes);

        // recursively merging in order step by step
        merge(L1, L2, list, comparator, alreadySortedAttributes);
    }
    private void merge(List<T> L1, List<T> L2,List<T> L, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes){
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < L1.size() && j < L2.size()) {
            // place the smaller of two values in result sublist
            // and move to the next value in the sublist with the selected one
            if(comparator.compareMultifield(L1.get(i), L2.get(j), alreadySortedAttributes) < 0) {
                L.set(k++, L1.get(i++));
            } else {
                L.set(k++, L2.get(j++));
            }
        }

        // place the rest of the values in result sublist
        while(i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while(j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }

}
