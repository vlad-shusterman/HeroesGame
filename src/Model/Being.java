package Model;

import java.awt.*;

public class Being implements Entity {
    private int health;
    private int stepArrange;
    private int might;
    private int moxie;
    private Coordinates coordinates;
    private int currentBlock;


    public Being(int health, int stepArrange, int might, int moxie) {
        this.coordinates = new Coordinates();
        coordinates.setX(currentBlock % 24 - 1);
        coordinates.setY(currentBlock / 24 - 1);
        this.health = health;
        this.stepArrange = stepArrange;
        this.might = might;
        this.moxie = moxie;

    }

    @Override
    public void move() {

    }

    public void setCurrentBlock(int currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public int getHealth() {
        return health;
    }

    public int getMight() {
        return might;
    }

    public int getMoxie() {
        return moxie;
    }

    public int getStepArrange() {
        return stepArrange;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMight(int might) {
        this.might = might;
    }

    public void setMoxie(int moxie) {
        this.moxie = moxie;
    }

    public void setStepArrange(int stepArrange) {
        this.stepArrange = stepArrange;
    }
}
