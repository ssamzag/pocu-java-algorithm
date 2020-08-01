package academy.pocu.comp2500.assignment4;

import java.awt.Point;
import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char c;
    private char pixel;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private boolean isExecuted = true;
    private String redoDraw, undoDraw;
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
        boolean bNotExists = true;
        for (int x = 0; x < canvas.getWidth(); ++x) {
            char pixel = canvas.getPixel(x, y);
            if (this.c != pixel) {
                bNotExists = false;
            }
            pixels.add(pixel);
        }

        if (bNotExists) {
            isExecuted = false;
            return false;
        }

        this.canvas = canvas;
        undoDraw = canvas.toString();
        canvas.fillHorizontalLine(y, c);
        redoDraw = canvas.toString();
        canExecute = false;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || !isExecuted || !redoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        if (!redoDraw.equals(canvas.toString())) {
            return false;
        }
        for (int x = 0; x < canvas.getWidth(); ++x) {
            canvas.drawPixel(x, y, pixels.get(x));
        }
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo || !isExecuted || !undoDraw.equals(canvas.getDrawing())) {
            return false;
        }
        if (!undoDraw.equals(canvas.toString())) {
            return false;
        }
        canvas.fillHorizontalLine(y, c);
        canUndo = true;
        return true;
    }
}
