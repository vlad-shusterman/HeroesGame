package Model;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private List army;
    private int healMight;
    private int makeArmorMight;

    public Hero (int healMight, int makeArmorMight) {
        this.healMight = healMight;
        this.makeArmorMight = makeArmorMight;
        army = new ArrayList();
    }

    public List getArmy() {
        return army;
    }

    public void setArmy(List army) {
        this.army = army;
    }

    public int getHealMight() {
        return healMight;
    }

    public void setHealMight(int healMight) {
        this.healMight = healMight;
    }

    public int getMakeArmorMight() {
        return makeArmorMight;
    }

    public void setMakeArmorMight(int makeArmorMight) {
        this.makeArmorMight = makeArmorMight;
    }
}
