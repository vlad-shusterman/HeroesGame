import Model.*;
import View.Battleground;

public class Main {

    public static void main(String[] args) {
        Hero hero1 = new Hero(10,15);
        GnomeFighter gnomeFighter = new GnomeFighter(1,1,1,1);
        gnomeFighter.setCurrentBlock(2);
        GnomeShooter gnomeShooter = new GnomeShooter(1,1,1,3);
        gnomeShooter.setCurrentBlock(3);
        hero1.addUnit(gnomeFighter);
        hero1.addUnit(gnomeShooter);
        Hero hero2 = new Hero(10,10);
        GnomeFighter gnomeFighter1 = new GnomeFighter(1,1,1,2);
        gnomeFighter1.setCurrentBlock(23);
        GnomeShooter gnomeShooter1 = new GnomeShooter(1,1,1,4);
        gnomeShooter1.setCurrentBlock(46);
        PixieDefault pixieDefault = new PixieDefault(1,1,1,1);
        pixieDefault.setCurrentBlock(49);
        PixieTop pixieTop = new PixieTop(1,1,1,1);
        pixieTop.setCurrentBlock(92);
        hero2.addUnit(gnomeFighter1);
        hero2.addUnit(pixieTop);
        hero2.addUnit(gnomeShooter1);
        hero2.addUnit(pixieDefault);
        Battleground battleground = new Battleground(hero1, hero2);
    }
}
