package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(0xE6E6E6),
    IVORY(0xFFFFF0),
    WHITE(0xFFFFFF);

    private final int value;

    private BusinessCardColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
