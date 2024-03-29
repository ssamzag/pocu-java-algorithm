package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {
    protected final int MAX_MEAT_COUNT;
    protected final int MAX_VEGGIE_COUNT;
    protected final int MAX_CHEESE_COUNT;
    protected int cheeseCount;
    protected int veggieCount;
    protected int meatCount;
    protected boolean isCheeseAdded;
    protected ArrayList<Topping> toppings = new ArrayList<>();

    protected Pizza(int price, int maxMeatCount, int maxVeggieCount, int maxCheeseCount) {
        this.price = price;
        MAX_MEAT_COUNT = maxMeatCount;
        MAX_VEGGIE_COUNT = maxVeggieCount;
        MAX_CHEESE_COUNT = maxCheeseCount;
    }

    protected static boolean isMeat(Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    protected static boolean isVeggie(Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    protected static boolean isCheese(Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

}
