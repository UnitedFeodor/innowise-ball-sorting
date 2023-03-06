package sorting;

import balls.AbstractBall;
import enums.BallAttribute;
import enums.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallSorter {
    private final List<BallAttribute> sortingAttributes = new ArrayList<>();
    private SortingAlgorithm sortingAlgorithm;

    public BallSorter(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public BallSorter setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
        return this;
    }
    public SortingAlgorithm getSortingAlgorithm() {
        return sortingAlgorithm;
    }


    public BallSorter addSortingAttribute(BallAttribute attribute) {
        if (!sortingAttributes.contains(attribute)) {
            sortingAttributes.add(attribute);
        }
        return this;
    }
    public List<BallAttribute> getSortingAttributes() {
        return Collections.unmodifiableList(sortingAttributes);
    }

    public BallSorter clearSortingAttributes() {
        sortingAttributes.clear();
        return this;
    }

    public List<AbstractBall> sortBallsByAttributes(List<AbstractBall> ballsToSort) {
        if (ballsToSort == null) {
            throw new NullPointerException("ballsToSort can't be null");
        }
        if (ballsToSort.isEmpty()) {
            throw new IllegalArgumentException("ballsToSort can't be empty");
        }
        if (sortingAttributes.isEmpty()) {
            return ballsToSort;
        }

        List<AbstractBall> sortedList = ballsToSort;
        List<BallAttribute> alreadySortedAttributes = new ArrayList<>();
        for(BallAttribute attribute : sortingAttributes) {
            sortedList = sortingAlgorithm.sortMultifield(ballsToSort,attribute,alreadySortedAttributes);
            alreadySortedAttributes.add(attribute);

            // TODO remove debug
            System.out.println("during sort: "+sortedList);
        }
        return sortedList;

    }

}
