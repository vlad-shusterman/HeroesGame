package Model;

public class Gnome implements Entity {
    private int health;
    private int stepArrange;
    private int might;
    private int moxie;

    @Override
    public void move() {

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
