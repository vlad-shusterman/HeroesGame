package View;

import Controller.Controller;
import Model.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;

public class Battleground {
    public static Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    public final int WIDTH = 24;
    public final int HEIGHT = 17;
    public final int BLOCKS = WIDTH * HEIGHT;
    private List<Block> blocks = new ArrayList<>(484);
    private Hero hero1;
    private Hero hero2;
    private Controller controller;
    private Composite compositeMain = new Composite(shell, SWT.NONE);
    private Composite compositeLeft = new Composite(compositeMain, SWT.NONE);
    private Composite compositeRight = new Composite(compositeMain, SWT.NONE);
    private Logs logs = new Logs();
    Observer observer;

    public Battleground(Hero hero1, Hero hero2) {
        shell.setText("Battleground");

        shell.setSize(1790, 880);
        this.hero1 = hero1;
        this.hero2 = hero2;
        Image hero1Image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/Hero1.png");
        Image hero2Image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/hero2.jpg");
        hero1.setImage(hero1Image);
        hero2.setImage(hero2Image);
        controller = new Controller(hero1, hero2);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_YELLOW);
        GridLayout gridLayout = new GridLayout();
        GridLayout gridLayout1 = new GridLayout();
        gridLayout1.numColumns = 2;
        compositeLeft.setLayout(gridLayout);
        compositeMain.setLayout(gridLayout1);
        GridLayout gridLayoutShell = new GridLayout();
        gridLayoutShell.numColumns = 2;
        shell.setLayout(gridLayoutShell);
        gridLayout.numColumns = WIDTH;
        shell.setBackground(gray);
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
        Label label = new Label(compositeRight, SWT.LEFT);
        label.setBounds(100,100,200,400);
        label.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        for (int block = 0; block < BLOCKS; block++) {
            Block button = new Block(compositeLeft, display, block);
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
                                if (fight.getResult() <= 0) {
                                    Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GRAY));
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                    controller.getCurrentUnit().setCurrentBlock(finalBlock);
                                    drawUnit(controller.getCurrentUnit());
                                    controller.deleteUnit(index, shell);
                                    controller.incrementStep();
                                    findActiveBlocks();
                                    observer.update("Yo ho ho");
                                    blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                } else {
                                    Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/field.jpg");
                                    controller.getQueue().get(index).setHealth(fight.getResult());
                                    if (controller.getCurrentUnit().getCoordinates().getX() > controller.getQueue().get(index).getCoordinates().getX()) {
                                        controller.getQueue().get(index).setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() - 1);
                                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                        controller.getCurrentUnit().setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() + 1);
                                        drawUnit(controller.getCurrentUnit());
                                        drawUnit(controller.getQueue().get(index));
                                        controller.incrementStep();
                                        findActiveBlocks();
                                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                    } else if (controller.getCurrentUnit().getCoordinates().getX() < controller.getQueue().get(index).getCoordinates().getX()) {
                                        controller.getQueue().get(index).setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() + 1);
                                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                        controller.getCurrentUnit().setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() - 1);
                                        drawUnit(controller.getCurrentUnit());
                                        drawUnit(controller.getQueue().get(index));
                                        controller.incrementStep();
                                        findActiveBlocks();
                                        blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                    } else if (controller.getCurrentUnit().getCoordinates().getX() == controller.getQueue().get(index).getCoordinates().getX()) {
                                        if (controller.getCurrentUnit().getCoordinates().getY() > controller.getQueue().get(index).getCoordinates().getY()) {
                                            controller.getQueue().get(index).setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() + 24);
                                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                            controller.getCurrentUnit().setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() - 24);
                                            drawUnit(controller.getCurrentUnit());
                                            drawUnit(controller.getQueue().get(index));
                                            controller.incrementStep();
                                            findActiveBlocks();
                                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                        } else {
                                            controller.getQueue().get(index).setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() - 24);
                                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).setButtonImage(image);
                                            controller.getCurrentUnit().setCurrentBlock(controller.getQueue().get(index).getCurrentBlock() + 24);
                                            drawUnit(controller.getCurrentUnit());
                                            drawUnit(controller.getQueue().get(index));
                                            controller.incrementStep();
                                            findActiveBlocks();
                                            blocks.get(controller.getCurrentUnit().getCurrentBlock()).getButton().setBackground(display.getSystemColor(SWT.COLOR_GREEN));
                                        }
                                    }
                                }
                                logs.update(controller.getCurrentUnit() + "\n" + " Damaged " + controller.getQueue().get(index) + "\n" + " in " + "\n" + fight.getResult() + "Damage");
//                                label.setText(logs.getLog());
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
        for (int i = 0; i < WIDTH; i++) {
            Image image = new Image(display, "C:/Users/vlads/IdeaProjects/HeroesUniversity/src/Images/HeroBlock.png");
            Button b = new Button(compositeLeft, SWT.ALT);
            b.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
            if (i == 0) {
                b.setImage(hero1.getImage());
            } else if (i == WIDTH - 1) {
                b.setImage(hero2.getImage());
            } else {
                b.setImage(image);
            }
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
