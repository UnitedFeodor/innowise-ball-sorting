package balls;

import balls.enums.Color;

public class Football extends AbstractBall{

    public static final int MIN_MASS = 410;
    public static final int MAX_MASS = 420;
    public static final int MIN_CIRCUMFERENCE = 680;
    public static final int MAX_CIRCUMFERENCE = 700;

    public Football(Color color, int circumferenceMM, int massG) {
        super(color, circumferenceMM, massG);
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void setCircumferenceMM(int newCircumferenceMM) {
        if (newCircumferenceMM < MIN_CIRCUMFERENCE || newCircumferenceMM > MAX_CIRCUMFERENCE) {
            throw new IllegalArgumentException("Circumference should be in the allowed range: from " + MIN_CIRCUMFERENCE + " to " + MAX_CIRCUMFERENCE);
        } else {
            this.circumferenceMM = newCircumferenceMM;
        }
    }

    @Override
    public void setMassG(int newMassG) {
        if (newMassG < MIN_MASS || newMassG > MAX_MASS) {
            throw new IllegalArgumentException("Mass should be in the allowed range: from " + MIN_MASS + " to " + MAX_MASS);
        } else {
            this.massG = newMassG;
        }
    }
}
