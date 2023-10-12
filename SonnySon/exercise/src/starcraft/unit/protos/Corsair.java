package starcraft.unit.protos;

import starcraft.unit.Brood;
import starcraft.unit.FlyAble;
import starcraft.unit.Unit;

public class Corsair extends Unit implements FlyAble {

    public Corsair() {
        super("Corsair", 4,12, Brood.PROTOS);
    }
}
