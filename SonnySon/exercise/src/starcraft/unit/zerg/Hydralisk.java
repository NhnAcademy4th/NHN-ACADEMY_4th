package starcraft.unit.zerg;

import starcraft.unit.Brood;
import starcraft.unit.Unit;

public class Hydralisk extends Unit implements Spitable{
    public Hydralisk() {
        super("Hydralisk", 3,7 ,Brood.ZERG);
    }
}