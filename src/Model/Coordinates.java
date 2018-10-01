package Model;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates (int currentStep) {
        if (currentStep < 24) {
            x = currentStep + 1;
            y = 1;
        } else {
            x = currentStep%24 + 1;
            y = currentStep/24 + 1;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
