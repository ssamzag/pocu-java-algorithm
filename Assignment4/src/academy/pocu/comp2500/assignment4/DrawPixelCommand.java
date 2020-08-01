package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private final char c;
    private boolean canExecute = true;
    private boolean canUndo;
    private Canvas canvas;
    private char pixel;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }
        this.canvas = canvas;
        this.pixel = canvas.getPixel(this.x, this.y);
        canvas.drawPixel(this.x, this.y, this.c);
        canExecute = false;
        canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        canvas.drawPixel(this.x, this.y, pixel);
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        canvas.drawPixel(this.x, this.y, c);
        canUndo = true;
        return true;
    }
}
