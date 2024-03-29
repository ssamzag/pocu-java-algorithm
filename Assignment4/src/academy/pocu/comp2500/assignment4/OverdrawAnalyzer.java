package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class OverdrawAnalyzer extends Canvas {
    private final Map<Point, LinkedList<Character>> pixelHistories = new HashMap<>();

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                pixelHistories.put(new Point(x, y), new LinkedList<Character>());
            }
        }
    }

    @Override
    public void drawPixel(int x, int y, char c) {
        if (getPixel(x, y) == c) {
            return;
        }

        super.drawPixel(x, y, c);
        getPixelHistory(x, y).add(getPixel(x, y));
    }

    @Override
    public void toUpper(int x, int y) {
        char pixel = getPixel(x, y);
        if (pixel < 'a' || pixel > 'z') {
            return;
        }

        super.toUpper(x, y);
    }
 
    @Override
    public void toLower(int x, int y) {
        char pixel = getPixel(x, y);
        if (pixel < 'A' || pixel > 'Z') {
            return;
        }

        super.toLower(x, y);
    }

    @Override
    public void fillHorizontalLine(int y, char c) {
        for (int x = 0; x < getWidth(); ++x) {
            char pixel = getPixel(x, y);
            if (pixel != c) {
                drawPixel(x, y, c);
            }
        }
    }

    @Override
    public void fillVerticalLine(int x, char c) {
        for (int y = 0; y < getHeight(); ++y) {
            char pixel = getPixel(x, y);
            if (pixel != c) {
                drawPixel(x, y, c);
            }
        }
    }

    @Override
    public void clear() {
        for (int x = 0; x < getWidth(); ++x) {
            for (int y = 0; y < getHeight(); ++y) {
                char c = getPixel(x, y);
                if (c != ' ') {
                    drawPixel(x, y, ' ');
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

    public int getOverdrawCount() {
        int count = 0;
        for (var history : pixelHistories.entrySet()) {
            count += history.getValue().size();
        }
        return count;
    }
}