package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo = true;
    private boolean isExecuted = true;
    private int x, y;
    private char pixel;
    private String undoDraw, redoDraw;

    public ToLowercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }
        canExecute = false;

        this.canvas = canvas;
        undoDraw = canvas.getDrawing();
        this.pixel = canvas.getPixel(x, y);
        canvas.toLower(x, y);
        redoDraw = canvas.getDrawing();

        return true;
    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo || redoDraw.equals(undoDraw) || !canvas.getDrawing().equals(redoDraw)) {
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
        if (canExecute || canUndo || !canvas.getDrawing().equals(undoDraw)) {
            return false;
        }

        canvas.toLower(x, y);

        canUndo = true;
        return true;
    }
}
