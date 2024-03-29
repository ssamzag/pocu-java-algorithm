package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int hp, int attackDamage, int defense) {
        super(name, hp, attackDamage, defense);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void attackTogether(Barbarian enemy) {
        if (this == enemy || null == this.pet) {
            return;
        }

        int damage = (int) ((super.getAttackDamage() + this.pet.getAttackDamage() - enemy.getDefense()) / 2.0);
        enemy.setHp(Math.max(damage, 1) * -1);
    }
}