package sorting;

import balls.AbstractBall;
import enums.BallAttribute;
import enums.SortType;

import java.util.ArrayList;
import java.util.List;

public class BallSorter {

    private List<BallAttribute> sortingAttributes = new ArrayList<>();

    private SortType sortType;


    public BallSorter addAttribute(BallAttribute attribute) {
        sortingAttributes.add(attribute);
        return this;
    }

    public List<AbstractBall> sortBallsByAttributes(List<AbstractBall> ballsToSort) {
        List<AbstractBall> sortedList = ballsToSort;
        for(BallAttribute attribute : sortingAttributes) {
            sortedList = sortType.sort(ballsToSort,attribute);
        }
        return sortedList;

    }



}
