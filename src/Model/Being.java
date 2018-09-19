package Model;

import org.eclipse.swt.graphics.Image;

public class Being implements Entity {
    private int health;
    private int stepArrange;
    private int might;
    public int moxie;
    private Coordinates coordinates;
    private int currentBlock;
    private Image image;

    public Being(int health, int stepArrange, int might, int moxie) {
        this.coordinates = new Coordinates();
        coordinates.setX(currentBlock % 24 - 1);
        coordinates.setY(currentBlock / 24 - 1);
        this.health = health;
        this.stepArrange = stepArrange;
        this.might = might;
        this.moxie = moxie;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }


    @Override
    public void move(int newBlock) {
        setCurrentBlock(newBlock);
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
