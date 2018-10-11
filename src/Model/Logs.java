package Model;

import java.util.Observable;
import java.util.Observer;

public class Logs implements Model.Observer {
    private String log = "";
    @Override
    public void update(String text) {
        this.log = text;

    }

    public String getLog() {
        return log;
    }
}
