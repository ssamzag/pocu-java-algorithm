package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductOption extends Product {
    private ArrayList<Aperture> apertures = new ArrayList<>();
    protected int width;
    protected int height;
    protected OrientationType orientation;
    protected static final int ADD_COST = 5;

    public void addAperture(Aperture aperture) {
        this.apertures.add(aperture);

        if (aperture.isValid()
                && aperture.getX() >= 0
                && aperture.getY() >= 0
                && aperture.getWidth() > 0
                && aperture.getHeight() > 0
                && aperture.getX() + aperture.getWidth() <= this.width
                && aperture.getY() + aperture.getHeight() <= this.height) {
            super.price += ADD_COST;
        }
    }

    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    public OrientationType getOrientation() {
        return orientation;
    }
}
