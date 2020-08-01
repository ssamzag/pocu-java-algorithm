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
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                pixels.put(new Point(x, y), DEFAULT_PIXEL);
            }
        }
    }

    public void drawPixel(final int x, final int y, final char c) {
        if (!isValidPoint(x, y) || !isValidPixelWord(c)) {
            return;
        }
        pixels.put(new Point(x, y), c);
    }

    public char getPixel(final int x, final int y) {
        return pixels.get(new Point(x, y));
    }

    public boolean increasePixel(final int x, final int y) {
        if (!isValidPoint(x, y)) {
            return false;
        }

        char c = (char) (getPixel(x, y) + 1);

        if (!isValidPixelWord(c)) {
            return false;
        }

        drawPixel(x, y, c);
        return true;

    }

    public boolean decreasePixel(final int x, final int y) {
        if (!isValidPoint(x, y)) {
            return false;
        }

        char c = (char) (getPixel(x, y) - 1);

        if (!isValidPixelWord(c)) {
            return false;
        }

        drawPixel(x, y, c);
        return true;

    }

    public void toUpper(final int x, final int y) {
        if (!isValidPoint(x, y)) {
            return;
        }

        drawPixel(x, y, Character.toUpperCase(getPixel(x, y)));
    }

    public void toLower(final int x, final int y) {
        if (!isValidPoint(x, y)) {
            return;
        }

        drawPixel(x, y, Character.toLowerCase(getPixel(x, y)));
    }

    public void fillHorizontalLine(final int y, final char c) {
        if (!isValidPointY(y) || !isValidPixelWord(c)) {
            return;
        }

        for (int x = 0; x < width; ++x) {
            drawPixel(x, y, c);
        }
    }

    public void fillVerticalLine(final int x, final char c) {
        if (!isValidPointX(x) || !isValidPixelWord(c)) {
            return;
        }

        for (int y = 0; y < height; ++y) {
            drawPixel(x, y, c);
        }
    }

    public void clear() {
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                pixels.put(new Point(x, y), DEFAULT_PIXEL);
            }
        }
    }

    public String getDrawing() {
        var drawing = new StringBuilder();
        var decoration = "+" + "-".repeat(width) + "+" + System.lineSeparator();

        drawing.append(decoration);
        for (int y = 0; y < height; ++y) {
            drawing.append("|");
            for (int x = 0; x < width; ++x) {
                drawing.append(getPixel(x, y));
            }
            drawing.append("|" + System.lineSeparator());
        }

        drawing.append(decoration);
        return drawing.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private boolean isValidPixelWord(final char c) {
        return c >= 32 && c <= 126;
    }

    private boolean isValidPointX(int x) {
        return x < width;
    }

    private boolean isValidPointY(int y) {
        return y < height;
    }

    private boolean isValidPoint(int x, int y) {
        return isValidPointX(x) && isValidPointY(y);
    }
}