package interfaces;

import java.util.List;

public interface MultifieldComparator<T,K>{

    /**
     * Works like compare() from Comparator<T> but doesn't change order
     * of elements specified in @param alreadySortedAttributes
     * @param o1
     * @param o2
     * @param alreadySortedAttributes
     * @return
     * for(BallAttribute attribute : alreadySortedAttributes) {
     *      int comparisonRes = attribute.compare(o1,o2);
     *       if (comparisonRes != 0) {
     *            return comparisonRes;
     *       }
     * }
     *  If not equal then the order is that result number else we continue
     */
    int compareMultifield(T o1, T o2, List<K> alreadySortedAttributes);

    /*
    *  for(BallAttribute attribute : alreadySortedAttributes) {
                int comparisonRes = attribute.compare(o1,o2);
                if (comparisonRes != 0) {
                    return comparisonRes;
                }
            }
    * if not equal then the order is that result number else we continue
    *
    */


}
