package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char c;
    private char pixel;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private Canvas canvas;
    private ArrayList<Character> pixels = new ArrayList<>();

    public FillHorizontalLineCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute || y > canvas.getHeight() - 1) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            pixels.add(canvas.getPixel(x, y));
        }
        this.canvas = canvas;
        canvas.fillHorizontalLine(y, c);
        canExecute = false;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, y, pixels.get(x));
        }
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }
        canvas.fillHorizontalLine(y, c);
        canUndo = true;
        return true;
    }
}
