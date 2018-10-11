package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class PixieTop extends Pixie {
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/pixie-top.gif");

    public PixieTop() {
        super(9, 5, 3, 2);
        setImage(image);
    }
}
