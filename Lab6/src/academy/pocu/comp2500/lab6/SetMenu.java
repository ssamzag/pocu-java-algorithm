package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Dessert> desserts = new ArrayList<Dessert>();
    protected ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();
    protected ArrayList<MainCourse> mainCourses= new ArrayList<MainCourse>();

    protected SetMenu() {
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }


}