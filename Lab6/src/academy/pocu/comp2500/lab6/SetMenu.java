package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
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

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }


}