import balls.AbstractBall;
import balls.Basketball;
import balls.Football;
import balls.GolfBall;
import sorting.BallSorter;
import sorting.algorithms.HeapSort;
import sorting.algorithms.MergeSort;
import balls.enums.Color;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sorting.attributes.comparators.CircumferenceComparator;
import sorting.attributes.comparators.ClassComparator;
import sorting.attributes.comparators.ColorComparator;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @BeforeAll
    static void before() {
        System.out.println("before all");
    }

    @Test
    void test1() {
        Football football1 = new Football(Color.WHITE,700,11);
        Football football2 = new Football(Color.BLACK,680,12);
        Basketball basketball1 = new Basketball(Color.WHITE,720,21);
        Basketball basketball2 = new Basketball(Color.WHITE,710,22);
        GolfBall golfBall1 = new GolfBall(Color.WHITE,GolfBall.MAX_CIRCUMFERENCE,GolfBall.MIN_MASS);
        // should be 11 21 12

        List<AbstractBall> list = new ArrayList<>();
        list.add(basketball1);
        list.add(football1);
        list.add(golfBall1);
        list.add(football2);
        list.add(basketball2);


        List<AbstractBall> listCopy = new ArrayList<>();
        for(AbstractBall ball : list) {
            listCopy.add(ball.clone());
        }

        BallSorter<AbstractBall> ballSorter = new BallSorter(new MergeSort<>());
        ballSorter.addSortingAttribute(new ClassComparator<>());
        ballSorter.addSortingAttribute(new ColorComparator<>());
        ballSorter.addSortingAttribute(new CircumferenceComparator<>());


        System.out.println("before merge sort: " + list);
        System.out.println("after merge sort: ");
        ballSorter.sortBallsByAttributes(list);
        printAll(list);

        System.out.println();
        ballSorter.setSortingAlgorithm(new HeapSort<>());
        System.out.println("before heap sort: " + listCopy);
        ballSorter.sortBallsByAttributes(listCopy);
        System.out.println("after heap sort: ");
        printAll(listCopy);

    }

    @Test
    void test2() {
        System.out.println("hi 2!");
    }

    public static  <T extends AbstractBall> void printAll(List<T> list) {
        System.out.println("\n==== printAll for " + list);
        for(var el : list) {
            System.out.println("class: " + el.getClass().getSimpleName());
            System.out.println("circumference: " + el.getCircumferenceMM());
            System.out.println("mass: " + el.getMassG());
            System.out.println("color: " + el.getColor());
            System.out.println("=======================");

        }
    }
}
