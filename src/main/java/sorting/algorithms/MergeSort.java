package sorting.algorithms;

import sorting.interfaces.MultifieldComparator;
import sorting.interfaces.MultifieldSort;

import java.util.ArrayList;
import java.util.List;

//MergeSort<T,K extends MultifieldComparator<T,K> & Comparator<T>> implements MultifieldSort<T,K>
public class MergeSort<T,K> implements MultifieldSort<T,K> {
    @Override
    public void sortMultifield(List<T> list, MultifieldComparator<T,K> comparator,List<K> alreadySortedAttributes){
        int size = list.size();

        // last sublist
        if (size < 2){
            return;
        }

        // each iteration divides it into two halves
        int half = size / 2;
        List<T> L1 = new ArrayList<T>(list.subList(0,half));
        List<T> L2 = new ArrayList<T>(list.subList(half,size));

        // recursively sorting each sublist
        sortMultifield(L1,comparator,alreadySortedAttributes);
        sortMultifield(L2,comparator,alreadySortedAttributes);

        // recursively merging in order ste[ by step
        merge(L1,L2,list,comparator, alreadySortedAttributes);
    }
    private  <T> void merge(List<T> L1, List<T> L2,List<T> L, MultifieldComparator<T,K> comparator, List<K> alreadySortedAttributes){
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < L1.size() && j < L2.size()) {

            // append the smaller of two values to result sublist
            if(comparator.compareMultifield(L1.get(i), L2.get(j), alreadySortedAttributes) < 0) {
                L.set(k++, L1.get(i++));
            } else {
                L.set(k++, L2.get(j++));
            }
        }

        // append the rest of the values to result sublist
        while(i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while(j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }

}
