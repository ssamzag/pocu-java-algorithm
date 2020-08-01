package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {
    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private final int x, y;
    private char pixel;

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
        canvas.increasePixel(x, y);
        canExecute = false;
        canUndo = true;

        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        canvas.decreasePixel(x, y);

        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        canvas.increasePixel(x, y);

        canUndo = true;
        return true;
    }
}
