package academy.pocu.comp2500.assignment2;

import java.awt.Point;

public enum BannerSize {
    W100_H50_CM(new Point(1000, 500)),
    W100_H100_CM(new Point(1000, 1000)),
    W200_H50_CM(new Point(2000, 500)),
    W300_H100_CM(new Point(3000, 1000));

    private Point value;
    private BannerSize(Point value) {
        this.value = value;
    }

    public Point getValue() {
        return this.value;
    }

}
