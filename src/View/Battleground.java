package View;

import Controller.Controller;
import Model.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class Battleground {
    public static Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    public final int WIDTH = 24;
    public final int HEIGHT = 19;
    public final int BLOCKS = WIDTH * HEIGHT;
    private List<Button> blocks = new ArrayList<>(484);
    private Hero hero1;
    private Hero hero2;
    private Controller controller;


    public Battleground(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        controller = new Controller(hero1, hero2);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_YELLOW);
        shell.setText("Battleground");
        shell.setSize(1386, 865);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = WIDTH;
        shell.setBackground(gray);
        shell.setLayout(gridLayout);
        drawField();
        drawUnits(hero1.getArmy());
        drawUnits(hero2.getArmy());
        blocks.get(controller.getCurrentUnit().getCurrentBlock()).setBackground(display.getSystemColor(SWT.COLOR_GREEN));
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void drawField() {
        for (int block = 0; block < BLOCKS; block++) {
            Button button = new Button(shell, SWT.NONE);
            button.setSize(new Point(200, 40));
            Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
            button.setImage(image);
            int finalBlock = block;
            button.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {
                    if (Math.abs(blocks.indexOf(button)-controller.getCurrentUnit().getCurrentBlock()) <= controller.getCurrentUnit().getStepArrange()){
                        Image image = button.getImage();
                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).setBackground(display.getSystemColor(SWT.COLOR_GRAY));
                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).setImage(image);
                        controller.getCurrentUnit().setCurrentBlock(finalBlock);
                        drawUnit(controller.getCurrentUnit());
                        controller.incrementStep();
                    }
                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                }
            });
            blocks.add(button);
        }
    }

    private void makeActie () {
    }

    private void redraw() {
        drawField();
        drawUnits(hero1.getArmy());
        drawUnits(hero2.getArmy());
    }

    private void drawUnit(Being being) {
        blocks.get(being.getCurrentBlock()).setImage(being.getImage());
    }

    private void drawUnits(List<Being> army) {
        army.forEach(this::drawUnit);
    }
}
