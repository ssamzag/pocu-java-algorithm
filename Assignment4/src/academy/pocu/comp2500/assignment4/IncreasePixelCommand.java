package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean isExecuted;
    private boolean canUndo;
    private int x, y;
    private char pixel;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isExecuted) {
            return false;
        }
        this.canvas = canvas;
        this.pixel = canvas.getPixel(x, y);
        canvas.increasePixel(x, y);
        isExecuted = true;
        canUndo = true;

        return true;
    }

    @Override
    public boolean undo() {
        if (!isExecuted || !canUndo) {
            return false;
        }
        if (this.pixel != canvas.getPixel(x, y)) {
            canvas.decreasePixel(x, y);
        }

        isExecuted = false;
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (!isExecuted || canUndo) {
            return false;
        }
        if (this.pixel != canvas.getPixel(x, y)) {
            canvas.increasePixel(x, y);
        }
        isExecuted = true;
        canUndo = true;
        return true;
    }
}
