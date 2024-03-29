package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private String undoDraw, redoDraw;
    private final int x, y;
    private char pixel;
    private boolean result;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }
        this.canvas = canvas;
        this.pixel = canvas.getPixel(x, y);
        undoDraw = canvas.getDrawing();
        result = canvas.increasePixel(x, y);
        redoDraw = canvas.getDrawing();
        canExecute = false;
        canUndo = true;

        return result;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || redoDraw.equals(undoDraw) || !canvas.getDrawing().equals(redoDraw)) {
            return false;
        }

        canvas.decreasePixel(x, y);
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo || !canvas.getDrawing().equals(undoDraw)) {
            return false;
        }

        canvas.increasePixel(x, y);
        canUndo = true;
        return true;
    }
}
