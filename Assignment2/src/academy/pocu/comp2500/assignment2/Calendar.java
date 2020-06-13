package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;
    private CalendarSize calendarSize;
    private CalendarColor calendarColor;

    public Calendar(CalendarType calendarType) {
        this.calendarType = calendarType;
        this.calendarSize = calendarType == CalendarType.WALL ? CalendarSize.W40_H40_CM :  calendarType == CalendarType.DESK ? CalendarSize.W20_H15_CM : CalendarSize.W10_H20_CM;
        this.calendarColor = CalendarColor.WHITE;
        super.price = getCalendarPrice();
        super.color = calendarColor.getValue();
    }

    private int getCalendarPrice() {
        switch(calendarType) {
            case WALL:
            case DESK:
                return 1000;
            case MAGNET:
                return 1500;
            default:
                assert (false);
        }

        return 0;
    }

    public CalendarColor getCalendarColor() {
        return calendarColor;
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }

    public CalendarSize getCalendarSize() {
        return calendarSize;
    }
}
