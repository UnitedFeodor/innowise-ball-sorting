package balls;


import balls.enums.Color;

import java.util.Objects;

public abstract class AbstractBall implements Cloneable {
    protected Color color;
    protected int circumferenceMM;
    protected int massG;

    public AbstractBall(Color color, int circumferenceMM, int massG) {
        this.color = color;
        this.circumferenceMM = circumferenceMM;
        this.massG = massG;
    }

    public Color getColor() {
        return color;
    }

    public int getCircumferenceMM() {
        return circumferenceMM;
    }

    public int getMassG() {
        return massG;
    }

    public abstract void setColor(Color newColor);
    public abstract void setCircumferenceMM(int newCircumferenceMM);
    public abstract void setMassG(int newMassG);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBall that = (AbstractBall) o;
        return circumferenceMM == that.circumferenceMM && massG == that.massG && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, circumferenceMM, massG);
    }

    @Override
    public String toString() {
        return "AbstractBall{" +
                "color=" + color +
                ", circumferenceMM=" + circumferenceMM +
                ", massG=" + massG +
                '}';
    }

    @Override
    public abstract AbstractBall clone();
}
