package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Restaurant {
    protected static int MAX_MEAT_COUNT;
    protected static int MAX_VEGGIE_COUNT;
    protected static int MAX_CHEESE_COUNT;

    protected int cheeseCount;
    protected int veggieCount;
    protected int meatCount;
    protected boolean isCheeseAdded;
    protected boolean isVeggieAdded;
    protected ArrayList<Topping> toppings = new ArrayList<>();

    public Pizza(int price) {
        super(price);
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

    public int getCheeseCount() {
        return this.cheeseCount;
    }

    public int getVeggieCount() {
        return this.veggieCount;
    }

    public int getMeatCount() {
        return this.meatCount;
    }



}
