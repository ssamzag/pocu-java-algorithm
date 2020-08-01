package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.HashMap;

public class Canvas {
    private final int width;
    private final int height;
    private final static char DEFAULT_PIXEL = ' ';

    private final HashMap<Point, Character> pixels = new HashMap<>();

    public Canvas(final int width, final int height) {
        this.width = width;
        this.height = height;

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                pixels.put(new Point(w, h), DEFAULT_PIXEL);
            }
        }
    }

    public void drawPixel(final int x, final int y, final char c) {
        if (x > width - 1 || y > height - 1 || !isAscii(c)) {
            return;
        }

        pixels.put(new Point(x, y), c);
    }

    public char getPixel(final int x, final int y) {
        return pixels.get(new Point(x, y));
    }

    public boolean increasePixel(final int x, final int y) {
        var point = new Point(x, y);

        if (pixels.get(point) == null) {
            return false;
        }

        char c = (char) (pixels.get(point) + 1);

        if (isAscii(c)) {
            pixels.replace(point, c);
            return true;
        }

        return false;
    }

    public boolean decreasePixel(final int x, final int y) {
        var point = new Point(x, y);

        if (pixels.get(point) == null) {
            return false;
        }

        char c = (char) (pixels.get(point) - 1);
        if (isAscii(c)) {
            pixels.replace(point, c);
            return true;
        }

        return false;
    }

    public void toUpper(final int x, final int y) {
        var point = new Point(x, y);

        if (pixels.get(point) == null) {
            return;
        }

        char c = pixels.get(point);
        pixels.replace(point, Character.toUpperCase(c));
    }

    public void toLower(final int x, final int y) {
        var point = new Point(x, y);
        if (pixels.get(point) == null) {
            return;
        }
        char c = pixels.get(point);
        pixels.replace(point, Character.toLowerCase(c));
    }

    public void fillHorizontalLine(final int y, final char c) {
        if (y > height - 1 || !isAscii(c)) {
            return;
        }

        for (int x = 0; x < height; x++) {
            pixels.put(new Point(x, y), c);
        }
    }

    public void fillVerticalLine(final int x, final char c) {
        if (x > width - 1 || !isAscii(c)) {
            return;
        }

        for (int y = 0; y < height; y++) {
            pixels.put(new Point(x, y), c);
        }
    }

    public void clear() {
        for (var pixel : pixels.entrySet()) {
            pixel.setValue(DEFAULT_PIXEL);
        }
    }

    public String getDrawing() {
        var drawing = new StringBuilder();
        for (int y = 0; y < height; y++) {
            if (y == 0) {
                drawing.append(String.format("%s%s%s%s", "+", "-".repeat(width), "+", System.lineSeparator()));
            }
            for (int x = 0; x < width; x++) {
                if (x == 0) {
                    drawing.append("|");
                }

                drawing.append(pixels.get(new Point(x, y)));

                if (x == width - 1) {
                    drawing.append("|" + System.lineSeparator());
                }
            }

            if (y == height - 1) {
                drawing.append(String.format("%s%s%s%s", "+", "-".repeat(width), "+", System.lineSeparator()));
            }

        }

        return drawing.toString();
    }

    public HashMap<Point, Character> getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private boolean isAscii(final char c) {
        return c >= 32 && c <= 126;
    }

}
