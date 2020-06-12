package academy.pocu.comp2500.lab5;

import java.util.ArrayList;
import java.util.HashMap;

public class Gladiator extends Barbarian {
    private final HashMap<String, Move> moveSet = new HashMap<>();
    private final int REST_HP = 10;

    public Gladiator(String name, int hp, int attackDamage, int defense) {
        super(name, hp, attackDamage, defense);
    }

    public boolean addMove(Move skill) {
        if (moveSet.size() < 4 && !this.moveSet.containsKey(skill.getSkillName())) {
            return this.moveSet.put(skill.getSkillName(), skill) == null;
        }

        return false;
    }

    public boolean removeMove(String skillName) {
        return this.moveSet.remove(skillName) != null;
    }

    public void attack(String skillName, Barbarian enemy) {
        if (this == enemy) {
            return;
        }
        Move move = moveSet.get(skillName);
        if (null == move || move.getSkillCount() == 0) {
            return;
        }

        int damage = (int) (((double) super.getAttackDamage() / enemy.getDefense() * move.getSkillDamage()) / 2.0);
        enemy.setHp(Math.max(damage, 1) * -1);
        move.addSkillCount(-1);
    }

    public void rest() {
        moveSet.forEach((key, move) -> {
            move.addSkillCount(1);
        });

        super.setHp(REST_HP);
    }
}