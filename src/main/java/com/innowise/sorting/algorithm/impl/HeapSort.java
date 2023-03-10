package com.innowise.sorting.algorithm.impl;

import com.innowise.sorting.algorithm.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeapSort <T> implements Sorter<T> {
    @Override
    public void sort(List<T> listToSort, Comparator<T> comparator) {
        int size = listToSort.size();

        // build heap (rearrange listToSort)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(listToSort, size, i,comparator);
        }

        // one by one extract an element from heap
        for (int i = size - 1; i >= 0; i--) {

            // move current root to the end
            Collections.swap(listToSort,0,i);

            // call max heapify on the reduced heap
            heapify(listToSort, i, 0,comparator);
        }
    }

    // heapify a subtree of size elements rooted with node i which is an index in tree
    void heapify(List<T> tree, int size, int root, Comparator<T> comparator) {
        // initialize max as root
        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // if left child is larger than root
        if (left < size && comparator.compare(tree.get(left),tree.get(max)) > 0) {
            max = left;
        }
        // if right child is larger than max
        if (right < size && comparator.compare(tree.get(right),tree.get(max)) > 0) {
            max = right;
        }
        // if max is not root then swap
        if (max != root) {
            Collections.swap(tree,root,max);
            // recursively heapify the affected subtree
            heapify(tree, size, max, comparator);
        }
    }
}
