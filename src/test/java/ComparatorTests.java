import com.innowise.ball.Basketball;
import com.innowise.ball.Football;
import com.innowise.ball.GolfBall;
import com.innowise.ball.attribute.Color;
import com.innowise.sorting.comparator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTests {

    @Test
    void comparatorsReturns() {
        Football football1 = new Football(Color.WHITE,700,Football.MIN_MASS);
        Football football2 = new Football(Color.BLACK,680,Football.MAX_MASS);
        Basketball basketball1 = new Basketball(Color.WHITE,760,Basketball.MIN_MASS);
        Basketball basketball2 = new Basketball(Color.WHITE,750,Basketball.MAX_MASS);
        GolfBall golfBall1 = new GolfBall(Color.WHITE,GolfBall.MAX_CIRCUMFERENCE,GolfBall.MIN_MASS);
        golfBall1.setDimpleAmount(GolfBall.MIN_DIMPLE_AMOUNT);
        GolfBall golfBall2 = new GolfBall(Color.WHITE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MAX_MASS);
        golfBall2.setDimpleAmount(GolfBall.MAX_DIMPLE_AMOUNT);

        assertAll("circumference comparator",
                () -> assertTrue(0 <
                        new CircumferenceComparator<>().compare(basketball1,football1)),
                () -> assertEquals(0,
                        new ClassComparator<>().compare(basketball1,basketball2)),
                () -> assertTrue(0 >
                        new ColorComparator<>().compare(football1,football2)),
                () -> assertTrue(0 >
                        new MassComparator<>().compare(football1,football2)),
                () -> assertTrue(0 <
                        new DimpleAmountComparator<>().compare(golfBall2,golfBall1))
                );
    }

}
