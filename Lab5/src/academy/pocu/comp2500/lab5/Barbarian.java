package academy.pocu.comp2500.lab5;

public class Barbarian {
    private int defense;
    private int attackDamage;
    private String name;
    private int hp;
    private int maxHp;

    public Barbarian(String name, int hp, int attackDamage, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

    public int getHp() {
        return this.hp;
    }

    public void attack(Barbarian enemy) {
        if (this == enemy) {
            return;
        }
        int damage = (int)((this.attackDamage - enemy.defense) / 2.0);
        enemy.setHp(Math.max(damage, 1) * -1);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    protected void setHp(int hp) {
        this.hp = Math.min(Math.max(this.hp + hp, 0), maxHp);
    }

    protected int getAttackDamage() {
        return attackDamage;
    }

    protected int getDefense() {
        return this.defense;
    }


}
