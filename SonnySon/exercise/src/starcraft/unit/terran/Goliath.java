package starcraft.unit.terran;

import starcraft.unit.Brood;
import starcraft.unit.Unit;

public class Goliath extends Unit implements MissileAble{
    public Goliath(){
        super("Goliath",5, 15, Brood.TERRAN);
    }
}
