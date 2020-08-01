package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.HashMap;

public class ClearCommand implements ICommand {
    private boolean canExecute = true;
    private boolean canUndo;
    private Canvas canvas;
    private final HashMap<Point, Character> pixels = new HashMap<>();

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }

        this.canvas = canvas;
        for (int x = 0; x < canvas.getWidth(); ++x) {
            for (int y = 0; y < canvas.getHeight(); ++y) {
                this.pixels.put(new Point(x, y), canvas.getPixel(x, y));
            }
        }

        canvas.clear();
        canExecute = false;
        canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        for (var pixel : pixels.entrySet()) {
            int x = pixel.getKey().x;
            int y = pixel.getKey().y;
            char c = pixel.getValue();
            this.canvas.drawPixel(x, y, c);
        }

        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        canvas.clear();
        canUndo = true;

        return true;
    }
}
