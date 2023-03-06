package interfaces;

import java.util.Comparator;
import java.util.List;

public interface Sort<T> {

    List<T> sort(List<T> listToSort, Comparator<T> comparator);

}
