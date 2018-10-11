package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class GnomeFighter extends Gnome {
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/gnome.gif");

    public GnomeFighter() {
        super(10, 5, 4, 4);
        setImage(image);
    }
}
