package academy.pocu.comp2500.assignment2;

import java.awt.Dimension;

public enum BusinessCardSize {
    W9_H5_CM(new Dimension(900, 500));

    private Dimension value;
    private BusinessCardSize(Dimension value) {
        this.value = value;
    }

    public Dimension getValue() {
        return this.value;
    }
}
