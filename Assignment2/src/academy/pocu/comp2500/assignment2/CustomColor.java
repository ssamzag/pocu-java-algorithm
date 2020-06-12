package academy.pocu.comp2500.assignment2;

import java.awt.Color;

public enum CustomColor {
    RED_BULL {
        int getRgbColor() {
            return 0xFF0000;
        }
    },
    BLUE_LAY {
        int getRgbColor() {
            return 0x0000FF;
        }
    },
    GREEN_LANTERN {
        int getRgbColor() {
            return 0x008000;
        }
    },
    WHITE_BOARD {
        int getRgbColor() {
            return 0xFFFFFF;
        }
    },
    GRAY_SEKIYA {
        int getRgbColor() {
            return 0xE6E6E6;
        }
    },
    IVORY_MAGIC {
        int getRgbColor() {
            return 0xFFFFF0;
        }
    };

    abstract int getRgbColor();
}