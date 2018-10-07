package View;

import Controller.Controller;
import Model.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;

public class Battleground {
    public static Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    public final int WIDTH = 24;
    public final int HEIGHT = 19;
    public final int BLOCKS = WIDTH * HEIGHT;
    private List<Block> blocks = new ArrayList<>(484);
    private Hero hero1;
    private Hero hero2;
    private Controller controller;


    public Battleground(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        controller = new Controller(hero1, hero2);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_YELLOW);
        shell.setText("Battleground");
        shell.setSize(1386, 880);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = WIDTH;
        shell.setBackground(gray);
        shell.setLayout(gridLayout);
        drawField();
        drawUnits(hero1.getArmy());
        drawUnits(hero2.getArmy());
        findActiveBlocks();
        blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
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
            Block button = new Block(shell, display, block);
            int finalBlock = block;
            button.getButton().addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {
                    if (controller.getCurrentUnit().checkMove(button.getCoordinates())) {
                        if (checkForbattle(controller.getCurrentUnit(), button) != 10000) {
                            int index = checkForbattle(controller.getCurrentUnit(), button);
                            if (index == -1) {
                                MessageBox messageBox = new MessageBox(shell, SWT.NONE);
                                messageBox.open();

                            } else {
                                Fight fight = new Fight(controller.getCurrentUnit(), controller.getQueue().get(checkForbattle(controller.getCurrentUnit(), button)));
                                if (fight.getResult() == 0) {
                                    Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GRAY));
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                    controller.getCurrentUnit().setCurrentBlock(finalBlock);
                                    drawUnit(controller.getCurrentUnit());
                                    controller.deleteUnit(index);
                                    controller.incrementStep();
                                    findActiveBlocks();
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                }
                            }
                        } else {
                            Image image = button.getImage();
                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GRAY));
                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                            controller.getCurrentUnit().setCurrentBlock(finalBlock);
                            drawUnit(controller.getCurrentUnit());
                            controller.incrementStep();
                            findActiveBlocks();
                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                        }
                    }
                }
            });
            blocks.add(button);
        }
    }

    private void makeActie() {
    }

    private int checkForbattle(Being being, Block block) {
        int check = 10000;
        for (int unit = 0; unit < controller.getQueue().size(); unit++) {
            if (block.getCurrentBlock() == controller.getQueue().get(unit).getCurrentBlock()) {
                if (controller.getQueue().get(unit).getHero() != controller.getCurrentUnit().getHero()) {
                    check = unit;
                } else {
                    check = -1;
                }
            }
        }
        return check;
    }

    private void redraw() {
        drawField();
        drawUnits(hero1.getArmy());
        drawUnits(hero2.getArmy());
    }

    private void drawUnit(Being being) {
        blocks.get(being.getCurrentBlock()).setButtonImage(being.getImage());
    }

    private void drawUnits(List<Being> army) {
        army.forEach(this::drawUnit);
    }

    public void findActiveBlocks() {
        for (int block = 0; block < blocks.size(); block++) {
            if (controller.getCurrentUnit().checkMove(blocks.get(block).getCoordinates())) {
                blocks.get(block).getButton().setBackground(display.getSystemColor(SWT.COLOR_DARK_YELLOW));
            } else {
                blocks.get(block).getButton().setBackground(display.getSystemColor(SWT.COLOR_WHITE));
            }
        }
    }
}
