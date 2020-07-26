package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Mine extends Unit {
    public Mine(IntVector2D vector, int x) {
        super.vector = vector;
        super.sign = "N";
        super.unitType = UnitType.GROUND;
        super.sight = 0;
        super.aoe = 0;
        super.ap = 10;
        super.hp = 1;
        super.possibleAttackTargets = EnumSet.of(UnitType.GROUND);
    }
}
