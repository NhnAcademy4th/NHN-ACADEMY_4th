package starcraft.unit.zerg;

import starcraft.unit.Brood;
import starcraft.unit.Unit;

public class Zergling extends Unit{
    public Zergling() {
        super("Zergling", 2,2 ,Brood.ZERG);
    }
    public void performAttack(Unit target) {
        attack(target);
    }
}