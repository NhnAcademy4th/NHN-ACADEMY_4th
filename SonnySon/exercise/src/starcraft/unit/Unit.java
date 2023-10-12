package starcraft.unit;

import starcraft.unit.protos.LaserAble;
import starcraft.unit.terran.MissileAble;
import starcraft.unit.zerg.Spitable;

public class Unit {
    int defaultStamina;
    Brood brood;
    String unitName;
    int stamina;
    int attackPower;

    public Unit(String UnitName, int attackPower, int stamina, Brood brood){
        this.unitName = UnitName;
        this.defaultStamina = stamina;
        this.stamina = stamina;
        this.attackPower = attackPower;
        this.brood = brood;
    }
    public void attack(Unit target) {
        if(this instanceof FlyAble ||
                this instanceof Spitable ||
                this instanceof MissileAble ||
                this instanceof LaserAble
        )
            target.setStamina(target.getStamina() - this.getAttackPower());
        else{
            if(target instanceof FlyAble)
                System.out.println("Can't reach to attack.");
            else
                target.setStamina(target.getStamina() - this.getAttackPower());
        }
    }
    public String getUnitName() { return unitName; }
    public int getAttackPower() {
        return attackPower;
    }
    public int getDefaultStamina(){
        return defaultStamina;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}