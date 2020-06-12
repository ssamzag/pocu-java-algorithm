package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        MeatLoverPizza meatLoverPizza = new MeatLoverPizza();
        boolean isAdded = meatLoverPizza.addGreenPeppers(); // true
        boolean isRemoved = meatLoverPizza.removeGreenPeppers(); // true
        isAdded = meatLoverPizza.addRedOnions(); // true
        boolean isValid = meatLoverPizza.isValid(); // true
        int price = meatLoverPizza.getPrice(); // 21
        ArrayList<Topping> toppings = meatLoverPizza.getToppings();
    }
}
