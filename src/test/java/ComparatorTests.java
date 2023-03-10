import com.innowise.ball.Basketball;
import com.innowise.ball.Football;
import com.innowise.ball.GolfBall;
import com.innowise.ball.attribute.Color;
import com.innowise.sorting.comparator.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComparatorTests {

    List<Football> footballList;
    List<Basketball> basketballList;
    List<GolfBall> golfBallList;
    @BeforeAll
    void initBalls() {
        Football football1 = new Football(Color.WHITE,700,Football.MIN_MASS);
        Football football2 = new Football(Color.BLACK,680,Football.MAX_MASS);
        Basketball basketball1 = new Basketball(Color.WHITE,760,Basketball.MIN_MASS);
        Basketball basketball2 = new Basketball(Color.ORANGE,750,Basketball.MAX_MASS);
        GolfBall golfBall1 = new GolfBall(Color.WHITE,GolfBall.MAX_CIRCUMFERENCE,GolfBall.MIN_MASS);
        golfBall1.setDimpleAmount(GolfBall.MIN_DIMPLE_AMOUNT);
        GolfBall golfBall2 = new GolfBall(Color.WHITE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MAX_MASS);
        golfBall2.setDimpleAmount(GolfBall.MAX_DIMPLE_AMOUNT);
        footballList = Arrays.asList(football1,football2);
        basketballList = Arrays.asList(basketball1,basketball2);
        golfBallList = Arrays.asList(golfBall1,golfBall2);

    }

    @Test
    void circumferenceComparatorReturns() {

        assertAll("circumference comparator",
                () -> assertTrue(0 <
                        new CircumferenceComparator<>().compare(basketballList.get(0),footballList.get(0))),
                () -> assertTrue(0 >
                        new CircumferenceComparator<>().compare(footballList.get(0),basketballList.get(0))),
                () -> assertTrue(0 ==
                        new CircumferenceComparator<>().compare(basketballList.get(0),basketballList.get(0)))
                );
    }

    @Test
    void classComparatorReturns() {
        assertAll("class comparator",
                () -> assertTrue(0 ==
                        new ClassComparator<>().compare(basketballList.get(0),basketballList.get(1))),
                () -> assertTrue(0 >
                        new ClassComparator<>().compare(basketballList.get(0),footballList.get(1))),
                () -> assertTrue(0 <
                        new ClassComparator<>().compare(golfBallList.get(0),footballList.get(0)))
        );

    }

    @Test
    void massComparatorReturns() {
        assertAll("mass comparator",
                () -> assertTrue(0 >
                        new MassComparator<>().compare(footballList.get(0),footballList.get(1))),
                () -> assertTrue(0 <
                        new MassComparator<>().compare(footballList.get(1),footballList.get(0))),
                () -> assertTrue(0 >
                        new MassComparator<>().compare(footballList.get(0),footballList.get(1)))
        );

    }

    @Test
    void dimpleAmountComparatorReturns() {
        assertAll("dimpleAmount comparator",
                () -> assertTrue(0 >
                        new DimpleAmountComparator<>().compare(golfBallList.get(0),golfBallList.get(1))),
                () -> assertTrue(0 <
                        new DimpleAmountComparator<>().compare(golfBallList.get(1),golfBallList.get(0))),
                () -> assertTrue(0 ==
                        new DimpleAmountComparator<>().compare(golfBallList.get(1),golfBallList.get(1)))
        );

    }

    @Test
    void colorComparatorReturns() {
        assertAll("color comparator",
                () -> assertTrue(0 >
                        new ColorComparator<>().compare(footballList.get(0),basketballList.get(1))),
                () -> assertTrue(0 <
                        new ColorComparator<>().compare(basketballList.get(1),footballList.get(0))),
                () -> assertTrue(0 ==
                        new ColorComparator<>().compare(golfBallList.get(1),golfBallList.get(1)))
        );

    }

}
