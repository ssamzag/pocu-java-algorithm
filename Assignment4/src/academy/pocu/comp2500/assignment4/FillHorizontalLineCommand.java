package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char c;
    private char pixel;
    private boolean canExecute = true;
    private boolean canUndo;
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

        for (int w = 0; w < canvas.getWidth(); w++) {
            pixels.add(canvas.getPixel(w, y));
        }
        this.canvas = canvas;
        canvas.fillHorizontalLine(y, c);
        canExecute = false;
        canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }
        for (int x = 0; x < pixels.size(); x++) {
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
