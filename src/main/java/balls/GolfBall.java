package balls;


import enums.Color;

public class GolfBall extends AbstractBall{

    public GolfBall() {
    }

    public GolfBall(Color color, int circumferenceMM, int massG) {
        super(color, circumferenceMM, massG);
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;

    }

    @Override
    public void setCircumferenceMM(int newCircumferenceMM) {
        if (newCircumferenceMM < 134 || newCircumferenceMM > 135) {

        } else {
            this.circumferenceMM = newCircumferenceMM;
        }
    }

    @Override
    public void setMassG(int newMassG) {
        if (newMassG < 45 || newMassG > 46) {

        } else {
            this.massG = newMassG;
        }
    }
}
