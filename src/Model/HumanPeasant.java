package Model;

import View.Battleground;
import org.eclipse.swt.graphics.Image;

public class HumanPeasant extends Human {
    private Image image = new Image(Battleground.display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/Human-peasant.jpg");

    public HumanPeasant() {
        super(9, 3, 2, 3);
        setImage(image);
    }
}
