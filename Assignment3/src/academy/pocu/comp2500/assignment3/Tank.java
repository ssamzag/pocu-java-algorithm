package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Tank extends Unit {
    public Tank(IntVector2D vector) {
        super.vector = vector;
        super.sign = "T";
        super.unitType = UnitType.GROUND;
        super.sight = 3;
        super.aoe = 1;
        super.ap = 8;
        super.hp = 85;
        super.possibleAttackTargets = EnumSet.of(UnitType.GROUND);
    }
}
