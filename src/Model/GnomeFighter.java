package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class GnomeFighter extends Gnome {
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/gnome.gif");

    public GnomeFighter(int health, int stepArrange, int might, int moxie) {
        super(health, stepArrange, might, moxie);
        setImage(image);
    }
}
