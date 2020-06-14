package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(0xFF0000),
    BLUE(0x0000FF),
    GREEN(0x00800);

    private final int value;

    private StampColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
