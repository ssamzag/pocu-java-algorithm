package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Wraith extends Unit{
    public Wraith(IntVector2D vector) {
        super.vector = vector;
        super.sign = "W";
        super.unitType = UnitType.AIR;
        super.sight = 4;
        super.aoe = 0;
        super.ap = 6;
        super.hp = 80;
        super.possibleAttackTargets = EnumSet.of(UnitType.GROUND, UnitType.AIR);

    }
}
