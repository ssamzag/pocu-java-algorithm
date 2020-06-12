package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(25);
        super.MAX_MEAT_COUNT = 2;
        super.MAX_VEGGIE_COUNT = 2;
    }

    public boolean isValid() {
        return this.meatCount == MAX_MEAT_COUNT
                && this.veggieCount == MAX_VEGGIE_COUNT
                && this.isCheeseAdded;
    }

    public boolean addTopping(Topping topping) {
        if ((isMeat(topping) && this.meatCount >= MAX_MEAT_COUNT)
                || (isVeggie(topping) && this.veggieCount >= MAX_VEGGIE_COUNT)
                || (isCheese(topping) && this.isCheeseAdded)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++this.meatCount;
        }

        if (isVeggie(topping)) {
            ++this.veggieCount;
        }

        if (isCheese(topping)) {
            this.isCheeseAdded = true;
        }

        return true;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            if (isMeat(topping)) {
                --this.meatCount;
            }

            if (isVeggie(topping)) {
                --this.veggieCount;
            }

            if (isCheese(topping)) {
                this.isCheeseAdded = false;
            }
        }

        return isRemoved;
    }


}
