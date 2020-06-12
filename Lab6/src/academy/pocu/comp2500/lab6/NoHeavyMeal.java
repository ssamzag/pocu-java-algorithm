package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class NoHeavyMeal extends SetMenu {
    public NoHeavyMeal() {
        super.price = 15;
    }

    public void setValid() {
        super.isValid = this.appetizers.size() == 2 && this.desserts.size() == 1;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();
        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
        setValid();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.add(dessert);
        setValid();
    }
}