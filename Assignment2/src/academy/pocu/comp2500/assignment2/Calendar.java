package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;
    private CalendarSize size;

    public Calendar() {

    }

    public void setWallCalendar() {
        this.type = CalendarType.WALL;
        this.size = CalendarSize.W40_H40_CM;
    }

    public void setDeskCalendar() {
        this.type = CalendarType.WALL;
        this.size = CalendarSize.W20_H15_CM;
    }

    public void setMagnetCalendar() {
        this.type = CalendarType.WALL;
        this.size = CalendarSize.W10_H20_CM;
    }

    public int getPrice() {
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
}
