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
        if (!isExecuted) {
            this.canvas = canvas;
            this.pixel = canvas.getPixel(x, y);
            canvas.increasePixel(x, y);
            isExecuted = true;
            canUndo = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (!isExecuted || !canUndo) {
            return false;
        }

        canvas.decreasePixel(x, y);
        isExecuted = false;
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (!isExecuted || canUndo) {
            return false;
        }

        canvas.increasePixel(x, y);
        isExecuted = true;
        canUndo = true;
        return true;
    }
}
