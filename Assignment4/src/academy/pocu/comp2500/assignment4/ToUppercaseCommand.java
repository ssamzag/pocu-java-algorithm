package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {

    private Canvas canvas;
    private boolean canExecute = true;
    private boolean canUndo = true;
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
        return true;

    }

    @Override
    public boolean undo() {
        if (canExecute || !canUndo) {
            return false;
        }
        canUndo = false;
        canvas.toLower(x, y);

        return true;
    }

    @Override
    public boolean redo() {
        if (canExecute || canUndo) {
            return false;
        }
        canUndo = true;
        canvas.toUpper(x, y);

        return true;
    }
}
