package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private final int x, y;
    private boolean result;
    private String undoDraw = "", redoDraw = "";

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

        result = canvas.decreasePixel(x, y);
        redoDraw = canvas.getDrawing();

        canExecute = false;
        canUndo = true;
        return result;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || !result || !redoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.increasePixel(x, y);
        undoDraw = canvas.getDrawing();
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo || !result || !undoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.decreasePixel(x, y);
        canUndo = true;
        return true;
    }
}
