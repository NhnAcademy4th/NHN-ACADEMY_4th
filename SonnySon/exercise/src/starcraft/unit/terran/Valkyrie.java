package starcraft.unit.terran;

import starcraft.unit.Brood;
import starcraft.unit.FlyAble;
import starcraft.unit.Unit;

public class Valkyrie extends Unit implements FlyAble {
    public Valkyrie(){
        super("Valkyrie",4,12, Brood.TERRAN);
    }
}
