package academy.pocu.comp2500.assignment2;

public enum CalendarType {
    WALL {
        public int getPrice() {
            return 1000;
        };
        public CalendarSize getSize() {
            return CalendarSize.SIZE_40X40_CM;
        }
    },
    DESK {
        public int getPrice() {
            return 1000;
        }
        public CalendarSize getSize() {
            return CalendarSize.SIZE_20X15_CM;
        }
    },
    MAGNET {
        public int getPrice() {
            return 1500;
        }
        public CalendarSize getSize() {
            return CalendarSize.SIZE_10X20_CM;
        }
    };


    abstract int getPrice();
    abstract CalendarSize getSize();
}
