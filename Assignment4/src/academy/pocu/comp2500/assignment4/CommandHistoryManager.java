package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ICommand command;
    private LinkedList<Canvas> canvases = new LinkedList<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        return command.execute(canvas);
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
