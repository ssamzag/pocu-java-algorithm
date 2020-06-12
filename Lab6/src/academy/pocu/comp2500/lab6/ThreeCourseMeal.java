package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu{

    public ThreeCourseMeal() {
        super(25);
    }

    private void setValid() {
        super.isValid = this.appetizers.size() == 1 && this.mainCourse != null && this.desserts.size() == 1;
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourse = mainCourse;
        setValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.add(appetizer);
        setValid();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.add(dessert);
        setValid();
    }
}
