package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {
    private ArrayList<Move> moveSet = new ArrayList<Move>();
    private final int REST_HP = 10;

    public Gladiator(String name, int hp, int attackDamage, int defense) {
        super(name, hp, attackDamage, defense);
    }

    public boolean addMove(Move skill) {
        if (moveSet.size() < 4 && null == getMoveBySkillNameOrNull(skill.getSkillName())) {
            return this.moveSet.add(skill);
        }

        return false;
    }

    public boolean removeMove(String skillName) {
        for (var move : this.moveSet) {
            if (move.getSkillName().equals(skillName)) {
                return this.moveSet.remove(move);
            }
        }
        return false;
    }

    public void attack(String skillName, Barbarian enemy) {
        if (this == enemy) {
            return;
        }
        Move move = getMoveBySkillNameOrNull(skillName);
        if (move == null || move.getSkillCount() == 0) {
            return;
        }

        int damage = (int)(((double)super.getAttackDamage() / (double)enemy.getDefense() * (double)move.getSkillDamage()) / 2.0);
        enemy.setHp(Math.max(damage, 1) * -1);
        move.addSkillCount(-1);
    }

    public void rest() {
        for (var move : moveSet) {
            move.addSkillCount(1);
        }

        super.setHp(REST_HP);
    }

    private Move getMoveBySkillNameOrNull(String skillName) {
        for (Move move : moveSet) {
            if (move.getSkillName().equals(skillName)) {
                return move;
            }
        }
        return null;
    }
}
