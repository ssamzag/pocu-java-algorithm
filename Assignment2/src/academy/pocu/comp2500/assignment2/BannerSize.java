package academy.pocu.comp2500.assignment2;

import java.awt.Dimension;

public enum BannerSize {
    W100_H50_CM(new Dimension(1000, 500)),
    W100_H100_CM(new Dimension(1000, 1000)),
    W200_H50_CM(new Dimension(2000, 500)),
    W300_H100_CM(new Dimension(3000, 1000));

    private Dimension value;
    private BannerSize(Dimension value) {
        this.value = value;
    }

    public Dimension getValue() {
        return this.value;
    }

}
