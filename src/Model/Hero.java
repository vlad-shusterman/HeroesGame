package Model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private List army;
    private int healMight;
    private int makeArmorMight;
    private Image image;

    public Hero(int healMight, int makeArmorMight) {
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

    public void addUnit(Being unit) {
        unit.setHero(this);
        army.add(unit);
    }

    public boolean checkForLoose () {
        return getArmy().size() == 0;
    }

    public void removeUnit (Being unit) {
        getArmy().remove(unit);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
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
