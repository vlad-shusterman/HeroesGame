package Controller;

import Model.Being;

import java.util.*;

public class Controller {
    private List<Being> queue = new ArrayList<>();

    public List<Being> sortUnits(List<Being> units1, List<Being> units2) {
        System.out.println(units1);
        queue.addAll(units1);
        queue.addAll(units2);
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
}
