package academy.pocu.comp2500.assignment2;

import java.awt.*;

public enum BusinessCardSize {
    W9_H5_CM(new Point(900, 500));

    private Point value;
    private BusinessCardSize(Point value) {
        this.value = value;
    }

    public Point getValue() {
        return this.value;
    }
}
