package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class GnomeShooter extends Gnome {
    private int shootsCount;
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/gnome-shooter.png");

    public GnomeShooter() {
        super(8, 3, 2, 2);
        setImage(image);
    }

    public void setShootsCount(int shootsCount) {
        this.shootsCount = shootsCount;
    }

    public int getShootsCount() {
        return this.shootsCount;
    }

    public Image getImage() {
        return image;
    }
}
