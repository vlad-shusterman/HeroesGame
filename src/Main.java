import Model.*;
import View.Battleground;

public class Main {

    public static void main(String[] args) {
        Hero hero1 = new Hero(10, 15);
        GnomeFighter gnomeFighter = new GnomeFighter();
        gnomeFighter.setCurrentBlock(2);
        GnomeShooter gnomeShooter = new GnomeShooter();
        gnomeShooter.setCurrentBlock(3);
        HumanPeasant humanPeasant = new HumanPeasant();
        humanPeasant.setCurrentBlock(1);
        hero1.addUnit(gnomeFighter);
        hero1.addUnit(humanPeasant);
        hero1.addUnit(gnomeShooter);
        Hero hero2 = new Hero(10, 10);
        GnomeFighter gnomeFighter1 = new GnomeFighter();
        gnomeFighter1.setCurrentBlock(23);
        GnomeShooter gnomeShooter1 = new GnomeShooter();
        gnomeShooter1.setCurrentBlock(46);
        PixieDefault pixieDefault = new PixieDefault();
        pixieDefault.setCurrentBlock(45);
        PixieTop pixieTop = new PixieTop();
        pixieTop.setCurrentBlock(92);
        hero2.addUnit(gnomeFighter1);
        hero2.addUnit(pixieTop);
        hero2.addUnit(gnomeShooter1);
        hero2.addUnit(pixieDefault);
        Battleground battleground = new Battleground(hero1, hero2);
    }
}
