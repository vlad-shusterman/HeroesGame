package Controller;

import Model.ArmyQueue;
import Model.Being;
import Model.Hero;

import java.util.*;

public class Controller {

    private ArmyQueue queue;

    public Controller(Hero hero1, Hero hero2) {
        queue = new ArmyQueue(hero1.getArmy(), hero2.getArmy());
    }

    public Being getCurrentUnit() {
        return queue.getCurrentUnit();
    }

    public List<Being> getQueue() {
        return queue.getQueue();
    }

    public int getCurrentStep() {
        return queue.getCurrentStep();
    }

    public void incrementStep() {
        queue.incrementStep();
    }

    public void deleteUnit(int index) {
        queue.deleteUnit(index);
    }
}
