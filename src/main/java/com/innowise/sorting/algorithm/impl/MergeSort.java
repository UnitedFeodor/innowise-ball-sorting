package com.innowise.sorting.algorithm.impl;

import com.innowise.sorting.algorithm.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements Sorter<T> {
    @Override
    public void sort(List<T> list, Comparator<T> comparator){
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
        sort(L1, comparator);
        sort(L2, comparator);

        // recursively merging in order step by step
        merge(L1, L2, list, comparator);
    }
    private void merge(List<T> sublist1, List<T> sublist2,List<T> mergedList, Comparator<T> comparator){
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < sublist1.size() && j < sublist2.size()) {
            // place the smaller of two values in result sublist
            // and move to the next value in the sublist with the selected one
            if(comparator.compare(sublist1.get(i), sublist2.get(j)) < 0) {
                mergedList.set(k++, sublist1.get(i++));
            } else {
                mergedList.set(k++, sublist2.get(j++));
            }
        }

        // place the rest of the values in result sublist
        while(i < sublist1.size()) {
            mergedList.set(k++, sublist1.get(i++));
        }
        while(j < sublist2.size()) {
            mergedList.set(k++, sublist2.get(j++));
        }
    }

}
