package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private char pixel;
    private final int x, y;
    private boolean result;

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
        this.pixel = canvas.getPixel(x, y);
        result = canvas.decreasePixel(x, y);
        canExecute = false;
        canUndo = true;
        return true;

    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }
        if (result) {
            canvas.increasePixel(x, y);
        }

        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        if (result) {
            canvas.decreasePixel(x, y);
        }

        canUndo = true;
        return true;
    }
}
