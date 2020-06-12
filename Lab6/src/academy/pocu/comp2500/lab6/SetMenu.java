package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Dessert> desserts;
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<MainCourse> mainCourses;

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
    public Dessert getDessert() {
        assert (this.desserts != null && this.desserts.size() > 0) : "call isValid() first!";
        return this.desserts.get(0);
    }

    public Appetizer getAppetizer() {
        assert (this.appetizers != null && this.appetizers.size() > 0) : "call isValid() first!";
        return this.appetizers.get(0);
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }


}