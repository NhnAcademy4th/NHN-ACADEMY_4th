package starcraft.unit.terran;

import starcraft.unit.Brood;
import starcraft.unit.FlyAble;
import starcraft.unit.Unit;

public class Wraith extends Unit implements FlyAble {
    public Wraith(){
        super("Wraith",3,10, Brood.TERRAN);
    }
}
