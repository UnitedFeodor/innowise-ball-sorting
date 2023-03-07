package sorting.interfaces;

import java.util.Comparator;
import java.util.List;

public interface MultifieldSort<T> {

    void sortMultifield(List<T> listToSort, MultifieldComparator<T> comparator, List<Comparator<T>> alreadySortedAttributes);

}
