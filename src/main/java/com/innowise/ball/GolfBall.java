package com.innowise.ball;


import com.innowise.ball.attribute.Color;

import java.util.Objects;

public class GolfBall extends AbstractBall{

    public static final int MIN_MASS = 45;
    public static final int MAX_MASS = 46;
    public static final int MIN_CIRCUMFERENCE = 134;
    public static final int MAX_CIRCUMFERENCE = 135;

    public static final int MIN_DIMPLE_AMOUNT = 300;
    public static final int MAX_DIMPLE_AMOUNT = 500;
    private int dimpleAmount = MIN_DIMPLE_AMOUNT;

    public GolfBall(Color color, int circumferenceMM, int massG) {
        super(color, circumferenceMM, massG);
        if (circumferenceMM < MIN_CIRCUMFERENCE || circumferenceMM > MAX_CIRCUMFERENCE) {
            throw new IllegalArgumentException("Circumference should be in the allowed range: from " + MIN_CIRCUMFERENCE + " to " + MAX_CIRCUMFERENCE);
        }
        if (massG < MIN_MASS || massG > MAX_MASS) {
            throw new IllegalArgumentException("Mass should be in the allowed range: from " + MIN_MASS + " to " + MAX_MASS);
        }

    }

    public GolfBall(Color color, int circumferenceMM, int massG, int dimpleAmount) {
        super(color, circumferenceMM, massG);
        if (circumferenceMM < MIN_CIRCUMFERENCE || circumferenceMM > MAX_CIRCUMFERENCE) {
            throw new IllegalArgumentException("Circumference should be in the allowed range: from " + MIN_CIRCUMFERENCE + " to " + MAX_CIRCUMFERENCE);
        }
        if (massG < MIN_MASS || massG > MAX_MASS) {
            throw new IllegalArgumentException("Mass should be in the allowed range: from " + MIN_MASS + " to " + MAX_MASS);
        }
        this.dimpleAmount = dimpleAmount;
    }

    public int getDimpleAmount() {
        return dimpleAmount;
    }

    public void setDimpleAmount(int dimpleAmount) {
        if (dimpleAmount < MIN_DIMPLE_AMOUNT || dimpleAmount > MAX_DIMPLE_AMOUNT) {
            throw new IllegalArgumentException("Dimple amount should be in the allowed range: from " + MIN_DIMPLE_AMOUNT + " to " + MAX_DIMPLE_AMOUNT);
        } else {
            this.dimpleAmount = dimpleAmount;
        }
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

    @Override
    public GolfBall clone() {
        GolfBall newGolfBall = new GolfBall(this.getColor(),this.getCircumferenceMM(),this.getMassG());
        newGolfBall.setDimpleAmount(this.dimpleAmount);
        return newGolfBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GolfBall golfBall = (GolfBall) o;
        return dimpleAmount == golfBall.dimpleAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dimpleAmount);
    }
}
