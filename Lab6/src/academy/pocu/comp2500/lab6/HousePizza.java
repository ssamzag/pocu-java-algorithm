package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(20, 2, 0, 0);
        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
        super.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public void setValid() {
        super.isValid = super.meatCount == MAX_MEAT_COUNT;
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.BACON);
        ++super.meatCount;
        setValid();
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.toppings.remove(Topping.BACON);

        if (isRemoved) {
            --this.meatCount;
        }
        setValid();
        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.PEPERONI);
        ++this.meatCount;
        setValid();
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --this.meatCount;
        }
        setValid();
        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.SAUSAGES);
        ++this.meatCount;
        setValid();
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            --this.meatCount;
        }

        setValid();

        return isRemoved;
    }
}