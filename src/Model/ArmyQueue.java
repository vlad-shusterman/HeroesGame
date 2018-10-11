package Model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class ArmyQueue {
    private List<Being> queue = new ArrayList<>();
    private Being currentUnit;
    private Hero currentHero;
    private int currentStep = 0;
    Hero hero1;
    Hero hero2;

    public ArmyQueue(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        queue.addAll(this.hero1.getArmy());
        queue.addAll(this.hero2.getArmy());
        sortUnits();
        currentUnit = queue.get(0);
    }

    public List<Being> sortUnits() {
        for (int unit = 0; unit < queue.size(); unit++) {
            for (int j = unit + 1; j < queue.size(); j++) {
                if (queue.get(unit).getMoxie() < queue.get(j).getMoxie()) {
                    Being tmp = queue.get(j);
                    queue.set(j, queue.get(unit));
                    queue.set(unit, tmp);
                }
            }
        }
        return queue;
    }

    public Being getCurrentUnit() {
        return currentUnit;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public List<Being> getQueue() {
        return queue;
    }

    public void incrementStep() {
        this.currentHero = null;
        if (currentStep == queue.size() - 1) {
            currentStep = 0;
        } else {
            currentStep++;
        }
        if (currentUnit.getMoxie() < 3) {
            this.currentHero = currentUnit.getHero();
        }
        currentUnit = queue.get(currentStep);
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public void deleteUnit(int index, Shell shell) {
        if (queue.get(index).getHero().getArmy().size() == 1) {
            queue.get(index).getHero().removeUnit(queue.get(index));
            queue.remove(index);
            currentStep--;
            MessageBox messageBox = new MessageBox(shell, SWT.NONE);
            messageBox.setMessage("YOU WON CONGRATULATIONS!!!!!");
            messageBox.open();
            shell.close();
        } else {
            queue.get(index).getHero().removeUnit(queue.get(index));
            queue.remove(index);
            currentStep--;
        }
    }
}
