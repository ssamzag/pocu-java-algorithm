package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.HashMap;

public class DecreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private final int x, y;
    private boolean result;
    private String backupDraw;
    private String backupDraw2;

    public DecreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }
        this.canvas = canvas;
        backupDraw = canvas.getDrawing();
        result = canvas.decreasePixel(x, y);
        backupDraw2 = canvas.getDrawing();

        canExecute = false;
        canUndo = true;
        return result;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || !result) {
            return false;
        }

        if (!backupDraw2.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.increasePixel(x, y);
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo || !result) {
            return false;
        }
        if (!backupDraw.equals(canvas.getDrawing())) {
            return false;
        }
        canvas.decreasePixel(x, y);
        canUndo = true;
        return true;
    }
}
