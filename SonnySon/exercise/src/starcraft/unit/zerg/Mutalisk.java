package starcraft.unit.zerg;

import starcraft.unit.Brood;
import starcraft.unit.FlyAble;
import starcraft.unit.Unit;

public class Mutalisk extends Unit implements FlyAble {
    public Mutalisk() {
        super("Mutalisk", 3,7 ,Brood.ZERG);
    }
}