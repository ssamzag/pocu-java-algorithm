package academy.pocu.comp2500.assignment4;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Canvas {
    private final int width;
    private final int height;
    private final char pixel = ' ';

    private final HashMap<Point, Byte> pixels = new HashMap<>();

    public Canvas(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public void drawPixel(final int x, final int y, final char c) {
        if (!isAscii(c)) {
            return;
        }
        pixels.put(new Point(x, y), (byte)c);
    }

    public char getPixel(final int x, final int y) {
        for (int i = 0; i < width; i++) {
            for (int j =)
        }
        return ' ';
    }

    public void getDrawing() {

    }

    public boolean isAscii(char c) {
        return (byte)c >= 32 && (byte)c <= 126;
    }
}
