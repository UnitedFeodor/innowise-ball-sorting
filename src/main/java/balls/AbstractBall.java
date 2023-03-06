package balls;

import java.awt.*;

public abstract class AbstractBall {

    private Color color;
    private int diameterMM;
    private int massG;

    public Color getColor() {
        return color;
    }

    public int getDiameterMM() {
        return diameterMM;
    }

    public int getMassG() {
        return massG;
    }

    public abstract void setColor(Color newColor);
    public abstract void setDiameterMM(int newDiameterMM);
    public abstract void setMassG(int massG);
}
