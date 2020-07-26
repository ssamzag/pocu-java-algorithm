package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Marine extends Unit {
    public Marine(IntVector2D vector) {
        super.vector = vector;
        super.sign = "M";
        super.unitType = UnitType.GROUND;
        super.sight = 2;
        super.aoe = 0;
        super.ap = 6;
        super.hp = 35;
        super.possibleAttackTargets = EnumSet.of(UnitType.AIR, UnitType.GROUND);
    }
}
