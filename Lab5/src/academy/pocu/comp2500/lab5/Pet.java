package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int attackDamage;

    public Pet(String name, int attackDamage) {
        this.name = name;
        this.attackDamage = attackDamage;
    }

    protected int getAttackDamage() {
        return attackDamage;
    }
}
