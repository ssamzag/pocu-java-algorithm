package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza {
    protected static int MAX_MEAT_COUNT;
    protected static int MAX_VEGGIE_COUNT;
    protected static int MAX_CHEESE_COUNT;

    protected int cheeseCount;
    protected int veggieCount;
    protected int meatCount;
    protected ArrayList<Topping> toppings = new ArrayList<>();

    private int price;

    public Pizza(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCheeseCount() {
        return this.cheeseCount;
    }

    public int getVeggieCount() {
        return this.veggieCount;
    }

    public int getMeatCount() {
        return this.meatCount;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

}
