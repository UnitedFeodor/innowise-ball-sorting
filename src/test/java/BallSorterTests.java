import com.innowise.ball.AbstractBall;
import com.innowise.ball.Basketball;
import com.innowise.ball.Football;
import com.innowise.ball.GolfBall;
import com.innowise.ball.attribute.Color;
import com.innowise.sorting.comparator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.innowise.sorting.BallSorter;
import com.innowise.sorting.algorithm.impl.HeapSort;
import com.innowise.sorting.algorithm.impl.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BallSorterTests {

    private List<AbstractBall> abstractBallsList;
    @Test
    void illegalArgumentsConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new BallSorter<AbstractBall>(null),
                "null constructor param"
        );
    }

    @Test
    void illegalArgumentsSetters() {
        assertThrows(IllegalArgumentException.class,
                () -> new BallSorter<AbstractBall>(new MergeSort<>()).setSortingAlgorithm(null),
                "null setter param"
        );
    }

    @Test
    void illegalArgumentSort() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());
        List<AbstractBall> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,
                () -> ballSorter.sortBallsByAttributes(null),
                "null sort param"
        );
        assertThrows(IllegalArgumentException.class,
                () -> ballSorter.sortBallsByAttributes(emptyList),
                "empty list sort param"
        );

    }

    @BeforeEach
    void initBallsList() {
        Football football1 = new Football(Color.WHITE,700,Football.MIN_MASS);
        Football football2 = new Football(Color.BLACK,680,Football.MAX_MASS);
        Basketball basketball1 = new Basketball(Color.WHITE,760,Basketball.MIN_MASS);
        Basketball basketball2 = new Basketball(Color.WHITE,750,Basketball.MAX_MASS);
        GolfBall golfBall1 = new GolfBall(Color.WHITE,GolfBall.MAX_CIRCUMFERENCE,GolfBall.MIN_MASS);
        golfBall1.setDimpleAmount(GolfBall.MIN_DIMPLE_AMOUNT);
        GolfBall golfBall2 = new GolfBall(Color.WHITE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MAX_MASS);
        golfBall2.setDimpleAmount(GolfBall.MAX_DIMPLE_AMOUNT);

        abstractBallsList = Arrays.asList(basketball1,football1,golfBall1,football2,basketball2,golfBall2);
    }

    @Test
    void emptyAttributesList() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());

        List<AbstractBall> sameAsInitialList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sameAsInitialList.add(ball.clone());
        }

        ballSorter.sortBallsByAttributes(abstractBallsList);
        assertArrayEquals(abstractBallsList.toArray(),sameAsInitialList.toArray());
    }


    @Test
    void mergeSortAlgorithmSingleAttribute() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());
        ballSorter.addSortingAttribute(new MassComparator<>());

        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }
        sortedList.sort(new MassComparator<>());

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getMassG(), abstractBallsList.get(i).getMassG(),
                    "wrong order after sorting");
        }
    }

    @Test
    void mergeSortAlgorithmMultipleAttributes() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());
        ballSorter.addSortingAttribute(new ColorComparator<>())
                .addSortingAttribute(new CircumferenceComparator<>());

        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }
        sortedList.sort(Comparator.comparing(AbstractBall::getColor).thenComparing(AbstractBall::getCircumferenceMM));

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getCircumferenceMM(), abstractBallsList.get(i).getCircumferenceMM(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getColor(), abstractBallsList.get(i).getColor(),
                    "wrong order after sorting");
        }

    }

    @Test
    void heapSortAlgorithmSingleAttribute() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new HeapSort<>());
        ballSorter.addSortingAttribute(new CircumferenceComparator<>());

        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }
        sortedList.sort(new CircumferenceComparator<>());

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getCircumferenceMM(), abstractBallsList.get(i).getCircumferenceMM(),
                    "wrong order after sorting");
        }
    }

    @Test
    void heapSortAlgorithmMultipleAttributes() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new HeapSort<>());
        ballSorter.addSortingAttribute(new ClassComparator<>())
                .addSortingAttribute(new ColorComparator<>());

        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }

        sortedList.sort(Comparator.comparing(abstractBall -> (Comparable) abstractBall.getClass().getSimpleName())
                .thenComparing(abstractBall -> ((AbstractBall) abstractBall).getColor()));

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getClass().getSimpleName(),
                    abstractBallsList.get(i).getClass().getSimpleName(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getColor(), abstractBallsList.get(i).getColor(),
                    "wrong order after sorting");
        }
    }

    @Test
    void specificChildClassSort() {
        GolfBall golfBall1 = new GolfBall(Color.WHITE,GolfBall.MAX_CIRCUMFERENCE,GolfBall.MIN_MASS);
        golfBall1.setDimpleAmount(GolfBall.MIN_DIMPLE_AMOUNT);
        GolfBall golfBall2 = new GolfBall(Color.BLUE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MAX_MASS);
        golfBall2.setDimpleAmount(GolfBall.MAX_DIMPLE_AMOUNT);
        GolfBall golfBall3 = new GolfBall(Color.WHITE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MIN_MASS);
        golfBall3.setDimpleAmount(GolfBall.MAX_DIMPLE_AMOUNT);

        List<GolfBall> golfBallList = Arrays.asList(golfBall1,golfBall2,golfBall3);

        BallSorter<GolfBall> golfBallSorter = new BallSorter<>(new HeapSort<>());
        golfBallSorter.addSortingAttribute(new DimpleAmountComparator<>())
                .addSortingAttribute(new ColorComparator<>())
                .addSortingAttribute(new MassComparator<>())
                .addSortingAttribute(new CircumferenceComparator<>())
                .addSortingAttribute(new ClassComparator<>());

        List<GolfBall> sortedList = new ArrayList<>();
        for(var ball : golfBallList) {
            sortedList.add(ball.clone());
        }

        sortedList.sort(Comparator.comparing(GolfBall::getDimpleAmount)
                .thenComparing(GolfBall::getColor)
                .thenComparing(GolfBall::getMassG)
                .thenComparing(GolfBall::getCircumferenceMM)
                .thenComparing(abstractBall -> (Comparable) abstractBall.getClass().getSimpleName()));

        golfBallSorter.sortBallsByAttributes(golfBallList);
        for(int i = 0; i < golfBallList.size(); i++) {
            assertEquals(sortedList.get(i).getClass().getSimpleName(),
                    golfBallList.get(i).getClass().getSimpleName(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getColor(), golfBallList.get(i).getColor(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getDimpleAmount(), golfBallList.get(i).getDimpleAmount(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getMassG(), golfBallList.get(i).getMassG(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getCircumferenceMM(), golfBallList.get(i).getCircumferenceMM(),
                    "wrong order after sorting");

        }
    }

    @Test
    void descendingSortSingleAttribute() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());
        ballSorter.addSortingAttribute(new MassComparator<>());
        ballSorter.setAscendingOrder(false);

        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }
        sortedList.sort(new MassComparator<>().reversed());

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getMassG(), abstractBallsList.get(i).getMassG(),
                    "wrong order after sorting");
        }
    }

    @Test
    void descendingSortMultipleAttributes() {
        BallSorter<AbstractBall> ballSorter = new BallSorter<>(new MergeSort<>());
        ballSorter.addSortingAttribute(new ColorComparator<>())
                .addSortingAttribute(new CircumferenceComparator<>());
        ballSorter.setAscendingOrder(false);
        List<AbstractBall> sortedList = new ArrayList<>();
        for(var ball : abstractBallsList) {
            sortedList.add(ball.clone());
        }
        sortedList.sort(Comparator.comparing(AbstractBall::getColor).thenComparing(AbstractBall::getCircumferenceMM).reversed());

        ballSorter.sortBallsByAttributes(abstractBallsList);
        for(int i = 0; i < abstractBallsList.size(); i++) {
            assertEquals(sortedList.get(i).getCircumferenceMM(), abstractBallsList.get(i).getCircumferenceMM(),
                    "wrong order after sorting");
            assertEquals(sortedList.get(i).getColor(), abstractBallsList.get(i).getColor(),
                    "wrong order after sorting");
        }

    }

    public static<T extends AbstractBall> void printAll(List<T> list) {
        System.out.println("\n==== printAll for " + list);
        for(var el : list) {
            System.out.println("class: " + el.getClass().getSimpleName());
            System.out.println("circumference: " + el.getCircumferenceMM());
            System.out.println("mass: " + el.getMassG());
            System.out.println("color: " + el.getColor());
            if (el instanceof GolfBall) {
                System.out.println("dimples: " + ((GolfBall) el).getDimpleAmount());
            }
            System.out.println("=======================");

        }
    }
}
