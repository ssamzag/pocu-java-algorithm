package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class SmartMine extends Mine {
    public SmartMine(IntVector2D vector, int x) {
        super(vector, x);
        super.sign = "A";
        super.sight = 1;
        super.ap = 15;
    }
}
