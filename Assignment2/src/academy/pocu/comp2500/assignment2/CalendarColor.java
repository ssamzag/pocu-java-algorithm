package academy.pocu.comp2500.assignment2;

public enum CalendarColor {
    WHITE(0xFFFFFF);

    private int value;
    private CalendarColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
