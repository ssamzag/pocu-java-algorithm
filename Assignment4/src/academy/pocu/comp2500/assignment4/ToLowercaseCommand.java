package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private Canvas canvas;
    private boolean isExecuted;
    private boolean canUndo;
    private int x, y;
    private char pixel;

    public ToLowercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            this.canvas = canvas;
            this.pixel = canvas.getPixel(x, y);
            canvas.toLower(x, y);
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
        if (pixel != canvas.getPixel(x, y)) {
            canvas.toUpper(x, y);
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
        if (pixel != canvas.getPixel(x, y)) {
            canvas.toLower(x, y);
        }

        isExecuted = true;
        canUndo = true;
        return true;
    }
}
