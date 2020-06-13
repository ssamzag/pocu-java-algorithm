package academy.pocu.comp2500.assignment2;

import java.awt.Color;

public class Stamp extends Product {
    private StampSize stampSize;

    public Stamp() {

    }

    public void setRedStamp(StampSize size) {
        super.color = StampColor.RED.getValue();
        this.stampSize = size;
    }

    public void setBlueStamp(StampSize size) {
        super.color = StampColor.BLUE.getValue();
        this.stampSize = size;
    }

    public void setGreenStamp(StampSize size) {
        super.color = StampColor.GREEN.getValue();
        this.stampSize = size;
    }

    public int getPrice(){
        switch(stampSize) {
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
