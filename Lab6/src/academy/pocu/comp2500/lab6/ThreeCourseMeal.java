package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ThreeCourseMeal extends SetMenu{

    public ThreeCourseMeal() {
        super.price = 25;
    }

    private void setValid() {
        super.isValid = this.appetizers.size() == 1 && this.mainCourses.size() == 1 && this.desserts.size() == 1;
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourses.clear();
        super.mainCourses.add(mainCourse);
        setValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();
        this.appetizers.add(appetizer);
        setValid();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();
        this.desserts.add(dessert);
        setValid();
    }
}
