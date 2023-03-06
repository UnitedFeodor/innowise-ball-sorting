package enums;

import balls.AbstractBall;
import interfaces.MultifieldComparator;
import interfaces.MultifieldSort;

import java.util.List;

public enum SortingAlgorithm implements MultifieldSort<AbstractBall,BallAttribute> {
    HEAP_SORT{
        @Override
        public List<AbstractBall> sortMultifield(List<AbstractBall> listToSort, MultifieldComparator<AbstractBall, BallAttribute> comparator, List<BallAttribute> alreadySortedAttributes) {
            for (int i = 0; i < listToSort.size(); i++) {

                // Inner nested loop pointing 1 index ahead
                for (int j = i + 1; j < listToSort.size(); j++) {

                    // Checking elements
                    if (comparator.compareMultifield(listToSort.get(j), listToSort.get(i),alreadySortedAttributes) < 0) {
                    //if (arr[j] < arr[i]) {

                        AbstractBall temp = listToSort.get(i);
                        listToSort.set(i, listToSort.get(j));
                        listToSort.set(j,temp);
                        // Swapping
                        /*
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;*/
                    }
                }
            }

            return listToSort; // TODO implement
        }
    },

    MERGE_SORT {
        @Override
        public List<AbstractBall> sortMultifield(List<AbstractBall> listToSort, MultifieldComparator<AbstractBall, BallAttribute> comparator, List<BallAttribute> alreadySortedAttributes) {
            return listToSort; // TODO implement
        }
    }
}
