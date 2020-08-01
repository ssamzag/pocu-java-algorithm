package academy.pocu.comp2500.assignment4;

public class CommandHistoryManager {
    private Canvas canvas;
    private ICommand command;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        command.execute(canvas);
        return true;
    }

    public boolean canUndo() {
        return true;
    }

    public boolean canRedo() {
        return true;
    }

    public boolean undo() {
        return true;
    }

    public boolean redo() {
        return true;
    }
}
