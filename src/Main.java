import Model.GnomeFighter;
import Model.GnomeShooter;
import Model.Hero;
import View.Battleground;

public class Main {

    public static void main(String[] args) {
        Hero hero1 = new Hero(10,15);
        GnomeFighter gnomeFighter = new GnomeFighter(1,1,1,1);
        gnomeFighter.setCurrentBlock(2);
        GnomeShooter gnomeShooter = new GnomeShooter(1,1,1,1);
        gnomeShooter.setCurrentBlock(3);
        hero1.addUnit(gnomeFighter);
        hero1.addUnit(gnomeShooter);
        Hero hero2 = new Hero(10,10);
        GnomeFighter gnomeFighter1 = new GnomeFighter(1,1,1,1);
        gnomeFighter1.setCurrentBlock(23);
        GnomeShooter gnomeShooter1 = new GnomeShooter(1,1,1,1);
        gnomeShooter1.setCurrentBlock(46);
        hero2.addUnit(gnomeFighter1);
        hero2.addUnit(gnomeShooter1);
        Battleground battleground = new Battleground(hero1, hero2);
    }
}
