package sorting.interfaces;

import java.util.List;

public interface MultifieldSort<T,K> {

    void sortMultifield(List<T> listToSort, MultifieldComparator<T,K> comparator, List<K> alreadySortedAttributes);

}
