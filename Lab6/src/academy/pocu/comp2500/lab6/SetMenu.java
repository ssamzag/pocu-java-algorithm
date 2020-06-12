package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Dessert> desserts = new ArrayList<>();
    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected MainCourse mainCourse;

    public SetMenu(int price) {
        super(price);
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDessert() {
        assert (this.desserts.size() > 0) : "call isValid() first!";
        return this.desserts;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourse == null) : "call isValid() first!";
        return this.mainCourse;
    }

    public ArrayList<Appetizer> getAppetizer() {
        assert (this.appetizers.size() > 0) : "call isValid() first!";
        return this.appetizers;
    }

}