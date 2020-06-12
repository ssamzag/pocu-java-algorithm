package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(PrintSize size, CalendarType type) {
        super.setPrintSize(size);
        super.setColor(CustomColor.WHITE_BOARD.getRgbColor());
    }

    public int getPrice() {
        switch(super.getPrintSize()) {
            case SIZE_40X40_CM:
            case SIZE_20X15_CM:
                return 1000;
            case SIZE_10X20_CM:
                return 1500;
            default:
                assert (false);
        }

        return -1;
    }
}
