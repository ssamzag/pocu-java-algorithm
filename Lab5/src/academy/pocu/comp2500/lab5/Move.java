package academy.pocu.comp2500.lab5;

public class Move {
    private final String skillName;
    private final int skillDamage;
    private int skillCount;
    private final int maxSkillCount;

    public Move(String skillName, int skillDamage, int skillCount) {
        this.skillName = skillName;
        this.skillDamage = skillDamage;
        this.skillCount = skillCount;
        this.maxSkillCount = skillCount;
    }

    protected String getSkillName() {
        return this.skillName;
    }

    protected int getSkillCount() {
        return this.skillCount;
    }

    protected void addSkillCount(int count) {
        this.skillCount = Math.min(Math.max(this.skillCount + count, 0), maxSkillCount);
    }

    protected int getSkillDamage() {
        return this.skillDamage;
    }
}