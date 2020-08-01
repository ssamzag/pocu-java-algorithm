package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private final HashMap<Point, LinkedList<Character>> pixelHistories = new HashMap<>();

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                pixelHistories.put(new Point(x, y), new LinkedList<Character>());
            }
        }
    }

    @Override
    protected boolean increasePixel(int x, int y) {
        boolean bResult = super.increasePixel(x, y);
        if (bResult) {
            getPixelHistory(x, y).push(getPixel(x, y));
        }
        return bResult;
    }

    @Override
    protected boolean decreasePixel(int x, int y) {
        boolean bResult = super.decreasePixel(x, y);
        if (bResult) {
            getPixelHistory(x, y).push(getPixel(x, y));
        }
        return bResult;
    }

    @Override
    protected void drawPixel(int x, int y, char c) {
        char pixel = getPixel(x, y);

        if (pixel == c) {
            return;
        }

        super.drawPixel(x, y, c);
        getPixelHistory(x, y).push(getPixel(x, y));

    }

    @Override
    protected void toUpper(int x, int y) {
        char pixel = getPixel(x, y);
        if (pixel == Character.toUpperCase(pixel)) {
            return;
        }

        super.toUpper(x, y);

        getPixelHistory(x, y).push(getPixel(x, y));
    }

    @Override
    protected void toLower(int x, int y) {
        char pixel = getPixel(x, y);
        if (pixel == Character.toLowerCase(pixel)) {
            return;
        }

        super.toLower(x, y);
        getPixelHistory(x, y).push(getPixel(x, y));
    }

    @Override
    protected void fillHorizontalLine(int y, char c) {
        for (int x = 0; x < getWidth(); ++x) {
            char pixel = getPixel(x, y);
            if (pixel == Character.toLowerCase(pixel)) {
                getPixelHistory(x, y).push(getPixel(x, y));
                drawPixel(x, y, c);
            }
        }
    }

    @Override
    protected void fillVerticalLine(int x, char c) {
        for (int y = 0; y < getWidth(); ++y) {
            char pixel = getPixel(x, y);
            if (pixel == Character.toLowerCase(pixel)) {
                getPixelHistory(x, y).push(getPixel(x, y));
                drawPixel(x, y, c);
            }
        }
    }

    @Override
    protected void clear() {
        for (int x = 0; x < getWidth(); ++x) {
            for (int y = 0; y < getHeight(); ++y) {
                Character c = getPixel(x, y);
                if (c != null && c != ' ') {
                    drawPixel(x, y, ' ');
                    getPixelHistory(x, y).push(c);
                }
            }
        }

    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return pixelHistories.get(new Point(x, y));
    }

    public int getOverdrawCount(int x, int y) {
        return getPixelHistory(x, y).size();
    }
}
