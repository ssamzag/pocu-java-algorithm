package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductOption extends Product {
    protected ArrayList<Aperture> apertures = new ArrayList<>();
    protected OrientationType orientation;
    protected static final int ADD_COST = 5;

    public void addAperture(Aperture aperture) {
        if (aperture.getX() < 0 || aperture.getY() < 0) {
            return;
        }

        this.apertures.add(aperture);
        super.price += ADD_COST;
    }

    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    public OrientationType getOrientation() {
        return orientation;
    }
}
