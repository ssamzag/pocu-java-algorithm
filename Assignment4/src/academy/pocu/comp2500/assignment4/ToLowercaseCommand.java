package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private boolean isExecuted = true;
    private int x, y;
    private char pixel;
    private String undoDraw = "", redoDraw = "";

    public ToLowercaseCommand(int x, int y) {
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
        canvas.toLower(x, y);
        redoDraw = canvas.getDrawing();
        canExecute = false;
        return true;

    }

    @Override
    public boolean undo() {
        if (canExecute || !isExecuted || !canUndo || !redoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.toUpper(x, y);
        undoDraw = canvas.getDrawing();
        canExecute = false;
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || !isExecuted || canUndo || !undoDraw.equals(canvas.getDrawing())) {
            return false;
        }

        canvas.toLower(x, y);

        canUndo = true;
        return true;
    }
}
