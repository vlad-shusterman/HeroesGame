package Model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Block {
    private Button button;
    private int currentBlock;
    Coordinates coordinates;

    public Block(Shell shell, Display display, int currentBlock) {
        button = new Button(shell, SWT.NONE);
        button.setSize(new Point(200, 40));
        this.currentBlock = currentBlock;
        coordinates = new Coordinates(currentBlock);
        Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
        button.setImage(image);
    }

    public Button getButton() {
        return button;
    }

    public void setButtonImage(Image image) {
        button.setImage(image);
    }

    public Image getImage() {
        return button.getImage();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
