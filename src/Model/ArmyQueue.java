package Model;

import java.util.ArrayList;
import java.util.List;

public class ArmyQueue {
    private List<Being> queue = new ArrayList<>();
    private Being currentUnit;
    private int currentStep = 0;


    public ArmyQueue(List<Being> units1, List<Being> units2) {
        queue.addAll(units1);
        queue.addAll(units2);
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
        if (currentStep == queue.size() - 1) {
            currentStep = 0;
        } else {
            currentStep++;
        }
        currentUnit = queue.get(currentStep);
    }

    public void deleteUnit (int index) {
        queue.remove(index);
    }
}
