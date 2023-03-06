package balls;

import enums.Color;

public class Football extends AbstractBall{

    public Football() {
        super();
    }

    public Football(Color color, int circumferenceMM, int massG) {
        super(color, circumferenceMM, massG);
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void setCircumferenceMM(int newCircumferenceMM) {
        if (newCircumferenceMM < 680 || newCircumferenceMM > 700) {

        } else {
            this.circumferenceMM = newCircumferenceMM;
        }
    }

    @Override
    public void setMassG(int newMassG) {
        if (newMassG < 410 || newMassG > 420) {

        } else {
            this.massG = newMassG;
        }
    }
}
