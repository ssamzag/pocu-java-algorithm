package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public abstract class Unit {
    private int unitNo;
    protected IntVector2D vector;
    protected int hp;
    protected int attackDamage;
    protected String sign;
    protected int sight;
    protected int aoe;
    protected int ap;
    protected EnumSet<UnitType> possibleAttackTargets;
    protected UnitType unitType;

    public IntVector2D getPosition() {
        return null;
    }

    public int getHp() {
        possibleAttackTargets = EnumSet.of(UnitType.AIR, UnitType.GROUND);
        if (EnumSet.of(UnitType.AIR, UnitType.GROUND).equals(possibleAttackTargets)) {
            // 둘다
        } else if (EnumSet.of(UnitType.AIR).equals(possibleAttackTargets)) {

        } else {

        }
        return -1;
    }

    public AttackIntent attack() {
        return null;
    };

    public void onAttacked(int damage) {

    };

    public void onSpawn() {

    };

    public char getSymbol() {
        return ' ';
    };
}