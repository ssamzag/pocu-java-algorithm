package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand implements ICommand {
    private final int x;
    private final char c;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private Canvas canvas;
    private final ArrayList<Character> pixels = new ArrayList<>();

    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute || x > canvas.getWidth() - 1) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            pixels.add(canvas.getPixel(this.x, y));
        }

        this.canvas = canvas;
        canvas.fillVerticalLine(x, c);
        canExecute = false;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        for (int y = 0; y < pixels.size(); ++y) {
            canvas.drawPixel(this.x, y, pixels.get(y));
        }
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        canvas.fillVerticalLine(this.x, c);
        canUndo = true;
        return true;
    }
}