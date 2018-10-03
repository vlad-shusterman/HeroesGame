package Model;

public class Fight {
    private Being being1;
    private Being being2;

    public Fight(Being unit1, Being unit2) {
        being1 = unit1;
        being2 = unit2;
    }

    public int getResult() {
        being2.setHealth(being2.getHealth() - being1.getMight());
        return being2.getHealth();
    }
}
