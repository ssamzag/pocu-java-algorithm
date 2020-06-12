package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Dessert> desserts;
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<MainCourse> mainCourses;

    protected SetMenu() {
    }

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

    public MainCourse getAppetizer() {
        assert (this.mainCourses != null && this.mainCourses.size() > 0) : "call isValid() first!";
        return this.mainCourses.get(0);
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }


}