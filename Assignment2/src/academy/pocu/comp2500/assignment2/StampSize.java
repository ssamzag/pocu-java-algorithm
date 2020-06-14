package academy.pocu.comp2500.assignment2;

import java.awt.Dimension;

public enum StampSize {
    W4_H3_CM(new Dimension(40, 30)),
    W5_H2_CM(new Dimension(50, 20)),
    W7_H4_CM(new Dimension(70, 40));

    private Dimension value;
    private StampSize(Dimension value) {
        this.value = value;
    }

    public Dimension getValue() {
        return this.value;
    }
}
