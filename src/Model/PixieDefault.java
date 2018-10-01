package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class PixieDefault extends Pixie {
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/pixie.jpg");

    public PixieDefault(int health, int stepArrange, int might, int moxie) {
        super(health, stepArrange, might, moxie);
        setImage(image);
    }
}
