package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private StampSize stampSize;
    private StampColor stampColor;
    private String text;

    public Stamp(StampSize size, StampColor color, String text) {
        this.stampSize = size;
        this.stampColor = color;
        this.text = text;
        super.color = color.getValue();
        super.price = getProductPrice();
    }

    public StampSize getStampSize() {
        return stampSize;
    }

    public StampColor getStampColor() {
        return stampColor;
    }

    public String getText() {
        return text;
    }

    private int getProductPrice() {
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
