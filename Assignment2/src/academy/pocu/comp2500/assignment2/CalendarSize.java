package academy.pocu.comp2500.assignment2;

import java.awt.Dimension;

public enum CalendarSize {
    W40_H40_CM(new Dimension(400, 400)),
    W20_H15_CM(new Dimension(200, 150)),
    W10_H20_CM(new Dimension(100, 200));

    private Dimension value;
    private CalendarSize(Dimension value) {
        this.value = value;
    }

    public Dimension getValue() {
        return this.value;
    }
}
