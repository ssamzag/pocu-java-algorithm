package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Dessert> desserts = new ArrayList<>();
    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<MainCourse> mainCourses = new ArrayList<>();

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDessert() {
        return this.desserts;
    }

    public ArrayList<MainCourse> getMainCourse() {
        return this.mainCourses;
    }


}