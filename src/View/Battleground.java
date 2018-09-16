package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Battleground {
    public static Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    public final int WIDTH = 24;
    public final int HEIGHT = 21;
    public final int BLOCKS = 504;

    public Battleground() {
        Color gray = display.getSystemColor(SWT.COLOR_DARK_YELLOW);
        shell.setText("Battleground");
        shell.setSize(1100, 695);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = WIDTH;
        shell.setBackground(gray);
        shell.setLayout(gridLayout);
        drawField();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void drawField() {
        for (int i=0; i< BLOCKS; i++) {
            Button b = new Button(shell, SWT.PUSH);
            b.setSize(new Point(200,40));
            Image image1 = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/gnome.gif");
            Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
            Image image2 = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/gnome-shooter.png");
            b.setImage(image);

            if (i ==1) {
                b.setImage(image1);
            }
            if (i == 26) {
                b.setImage(image2);
            }
        }
    }

    private void drawUnits () {

    }
}
