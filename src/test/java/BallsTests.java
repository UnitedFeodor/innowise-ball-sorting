import com.innowise.ball.Basketball;
import com.innowise.ball.Football;
import com.innowise.ball.GolfBall;
import com.innowise.ball.attribute.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BallsTests {

    @Test
    void illegalArgumentsBallConstructors() {

        assertAll("Constructors for ball classes",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Basketball(Color.BLUE,0,Basketball.MIN_MASS);
                        },"basketball circumference"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Basketball(Color.BLUE,Basketball.MAX_CIRCUMFERENCE,-1);
                        }, "basketball mass"

                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Football(Color.WHITE,111110,Football.MIN_MASS);
                        },"football circumference"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Football(Color.WHITE,Football.MAX_CIRCUMFERENCE,-121313);
                        }, "football mass"

                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Football(Color.WHITE,0,GolfBall.MIN_MASS);
                        },"golfball circumference"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Football(Color.WHITE, GolfBall.MAX_CIRCUMFERENCE,123132);
                        }, "golfball mass"

                )
        );
    }

    @Test
    void illegalArgumentBallSetters() {
        Basketball basketball = new Basketball(Color.WHITE,Basketball.MIN_CIRCUMFERENCE,Basketball.MIN_MASS);
        Football football = new Football(Color.WHITE,Football.MIN_CIRCUMFERENCE,Football.MIN_MASS);
        GolfBall golfBall = new GolfBall(Color.WHITE,GolfBall.MIN_CIRCUMFERENCE,GolfBall.MIN_MASS);

        assertAll("Setters for ball classes",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            basketball.setCircumferenceMM(0);
                        },"basketball circumference"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            basketball.setMassG(0);
                        },"basketball mass"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            football.setCircumferenceMM(0);
                        },"football circumference"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            football.setMassG(0);
                        },"football mass"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            golfBall.setCircumferenceMM(0);
                        },"golfBall circumference"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            golfBall.setMassG(0);
                        },"golfBall mass"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            golfBall.setDimpleAmount(-5);
                        },"golfBall dimple amount")
        );
    }
}
