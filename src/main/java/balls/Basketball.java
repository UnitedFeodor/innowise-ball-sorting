package balls;


import enums.Color;

public class Basketball extends AbstractBall{

    public Basketball() {
        super();
    }

    public Basketball(Color color, int circumferenceMM, int massG) {
        super(color, circumferenceMM, massG);
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void setCircumferenceMM(int newCircumferenceMM) {
        if (newCircumferenceMM < 750 || newCircumferenceMM > 760) {

        } else {
            this.circumferenceMM = newCircumferenceMM;
        }
    }

    @Override
    public void setMassG(int newMassG) {
        if (newMassG < 580 || newMassG > 600) {

        } else {
            this.massG = newMassG;
        }
    }
}
