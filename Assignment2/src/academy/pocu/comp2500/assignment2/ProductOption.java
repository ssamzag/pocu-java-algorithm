package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductOption extends Product {
    protected ArrayList<Aperture> apertures = new ArrayList<>();
    protected OrientationType orientation;
    protected static final int ADD_COST = 5;

    public void addAperture(Aperture aperture) {
        this.apertures.add(aperture);
    }

    public OrientationType getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationType orientation) {
        this.orientation = orientation;
    }
}
