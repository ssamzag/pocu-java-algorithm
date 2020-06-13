package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private StampSize stampSize;

    public Stamp(StampSize size, StampColor color) {
        this.stampSize = size;
        super.color = color.getValue();
        super.price = getProductPrice();
    }

    public int getProductPrice() {
        switch (stampSize) {
            case W4_H3_CM:
            case W5_H2_CM:
                return 2300;
            case W7_H4_CM:
                return 2600;
            default:
                assert (false);
        }
        return -1;
    }
}
