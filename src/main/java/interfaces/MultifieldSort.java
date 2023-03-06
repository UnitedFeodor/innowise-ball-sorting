package interfaces;

import java.util.List;

public interface MultifieldSort<T,K> {

    List<T> sortMultifield(List<T> listToSort, MultifieldComparator<T,K> comparator, List<K> alreadySortedAttributes);

}
