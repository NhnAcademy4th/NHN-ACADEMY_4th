package starcraft.unit.protos;

import starcraft.unit.Brood;
import starcraft.unit.Unit;

public class Dragoon extends Unit implements LaserAble{
    public Dragoon(){
        super("Dragoon",3,15, Brood.PROTOS);
    }
}
