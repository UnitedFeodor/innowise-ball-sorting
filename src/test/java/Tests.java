import balls.AbstractBall;
import balls.Basketball;
import balls.Football;
import sorting.algorithms.HeapSort;
import sorting.algorithms.MergeSort;
import sorting.enums.BallAttribute;
import balls.enums.Color;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sorting.BallSorter;

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
        // should be 11 21 12

        List<AbstractBall> list = new ArrayList<>();
        list.add(basketball1);
        list.add(football1);
        list.add(football2);
        list.add(basketball2);

        BallSorter ballSorter = new BallSorter(new MergeSort<>());

        ballSorter.addSortingAttribute(BallAttribute.COLOR);
        ballSorter.addSortingAttribute(BallAttribute.CIRCUMFERENCE);
        System.out.println("before merge sort: " + list);
        System.out.println("after merge sort: "+ ballSorter.sortBallsByAttributes(list));

        System.out.println();
        ballSorter.setSortingAlgorithm(new HeapSort<>());
        System.out.println("before heap sort: " + list);
        System.out.println("after heap sort: "+ ballSorter.sortBallsByAttributes(list));

    }

    @Test
    void test2() {
        System.out.println("hi 2!");
    }
}
