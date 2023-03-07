package sorting;

import balls.AbstractBall;
import sorting.enums.BallAttribute;
import sorting.interfaces.MultifieldSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallSorter {
    private final List<BallAttribute> sortingAttributes = new ArrayList<>();
    private MultifieldSort<AbstractBall,BallAttribute> sortingAlgorithm;

    public BallSorter(MultifieldSort<AbstractBall,BallAttribute> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public BallSorter setSortingAlgorithm(MultifieldSort<AbstractBall,BallAttribute> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
        return this;
    }
    public MultifieldSort<AbstractBall, BallAttribute> getSortingAlgorithm() {
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

        List<AbstractBall> listCopy = new ArrayList<>();
        for(var ball : ballsToSort) {
            listCopy.add(ball.clone());
        }
        List<BallAttribute> alreadySortedAttributes = new ArrayList<>();
        for(BallAttribute attribute : sortingAttributes) {
            sortingAlgorithm.sortMultifield(listCopy,attribute,alreadySortedAttributes);
            alreadySortedAttributes.add(attribute);

            // TODO remove debug
            System.out.println("during sort: "+listCopy);
        }
        return listCopy;

    }

}
