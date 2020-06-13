package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;
    private CalendarSize size;

    public void setWallCalendar() {
        this.type = CalendarType.WALL;
        this.size = CalendarSize.W40_H40_CM;
        super.price = getCalendarPrice();
        super.color = 0xFFFFFF;
    }

    public void setDeskCalendar() {
        this.type = CalendarType.DESK;
        this.size = CalendarSize.W20_H15_CM;
        super.price = getCalendarPrice();
        super.color = 0xFFFFFF;
    }

    public void setMagnetCalendar() {
        this.type = CalendarType.MAGNET;
        this.size = CalendarSize.W10_H20_CM;
        super.price = getCalendarPrice();
        super.color = 0xFFFFFF;
    }

    private int getCalendarPrice() {
        switch(type) {
            case WALL:
            case DESK:
                return 1000;
            case MAGNET:
                return 1500;
            default:
                assert (false);
        }

        return -1;
    }

    public CalendarType getType() {
        return type;
    }

    public CalendarSize getSize() {
        return size;
    }
}
