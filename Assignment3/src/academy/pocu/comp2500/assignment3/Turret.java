package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Turret extends Unit {
    public Turret(IntVector2D vector) {
        super.vector = vector;
        super.sign = "U";
        super.unitType = UnitType.GROUND;
        super.sight = 2;
        super.aoe = 0;
        super.ap = 7;
        super.hp = 99;
        super.possibleAttackTargets = EnumSet.of(UnitType.AIR);
    }
}
