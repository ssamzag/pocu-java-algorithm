package academy.pocu.comp2500.assignment2;

import java.awt.Color;

public class Stamp extends Product {
    public Stamp(PrintSize size, int color) {
        super.setPrintSize(size);
        super.setColor(color);
        super.setPrice(getPrice());
    }

    public int getPrice(){
        switch(super.getPrintSize()) {
            case SIZE_4X3_CM:
            case SIZE_5X2_CM:
                return 2300;
            case SIZE_7X4_CM:
                return 2600;
            default:
                assert (false);
        }
        return -1;
    }
}
