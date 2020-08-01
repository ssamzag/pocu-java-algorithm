package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {

    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo;
    private int x, y;


    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!canExecute) {
            return false;
        }
        this.canvas = canvas;
        canvas.toUpper(x, y);
        canExecute = false;
        canUndo = true;
        return true;

    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }

        canvas.toLower(x, y);
        canUndo = false;
        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }

        canvas.toUpper(x, y);
        canUndo = true;
        return true;
    }
}
