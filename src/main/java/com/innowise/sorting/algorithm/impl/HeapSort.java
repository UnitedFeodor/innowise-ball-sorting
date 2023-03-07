package com.innowise.sorting.algorithm.impl;

import com.innowise.sorting.algorithm.MultifieldSort;
import com.innowise.sorting.comparator.MultifieldComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeapSort <T> implements MultifieldSort<T> {
    @Override
    public void sortMultifield(List<T> listToSort, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes) {
        int size = listToSort.size();

        // build heap (rearrange listToSort)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(listToSort, size, i,comparator,alreadySortedAttributes);
        }

        // one by one extract an element from heap
        for (int i = size - 1; i >= 0; i--) {

            // move current root to the end
            Collections.swap(listToSort,0,i);

            // call max heapify on the reduced heap
            heapify(listToSort, i, 0,comparator,alreadySortedAttributes);
        }
    }

    // heapify a subtree of size elements rooted with node i which is an index in tree
    void heapify(List<T> tree, int size, int i, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes) {
        // initialize max as root
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than root
        if (left < size && comparator.compareMultifield(tree.get(left),tree.get(max),alreadySortedAttributes) > 0) {
            max = left;
        }
        // if right child is larger than max
        if (right < size && comparator.compareMultifield(tree.get(right),tree.get(max),alreadySortedAttributes) > 0) {
            max = right;
        }
        // if max is not root then swap
        if (max != i) {
            Collections.swap(tree,i,max);
            // recursively heapify the affected subtree
            heapify(tree, size, max, comparator, alreadySortedAttributes);
        }
    }
}
