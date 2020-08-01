package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand implements ICommand {
    private final int x;
    private final char c;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private boolean isExecuted = true;
    private String undoDraw = "", redoDraw = "";
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
        boolean bNotExists = true;

        for (int y = 0; y < canvas.getHeight(); ++y) {
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
        canvas.fillVerticalLine(x, c);
        redoDraw = canvas.getDrawing();
        canExecute = false;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || !isExecuted || !redoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        for (int y = 0; y < pixels.size(); ++y) {
            canvas.drawPixel(this.x, y, pixels.get(y));
        }
        undoDraw = canvas.getDrawing();
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo || !isExecuted || !undoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.fillVerticalLine(this.x, c);
        canUndo = true;
        return true;
    }
}