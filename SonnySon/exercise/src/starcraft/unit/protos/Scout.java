package starcraft.unit.protos;

import starcraft.unit.Brood;
import starcraft.unit.FlyAble;
import starcraft.unit.Unit;

public class Scout extends Unit implements FlyAble {
    public Scout(){
        super("Scout",5,10, Brood.PROTOS);
    }
}
