package academy.pocu.comp2500.assignment4;

import java.util.Stack;

public class CommandHistoryManager {
    private final Canvas canvas;
    private final Stack<ICommand> undoStack = new Stack<>();
    private final Stack<ICommand> redoStack = new Stack<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        boolean result = command.execute(canvas);

        if (result) {
            undoStack.push(command);
            redoStack.clear();
        }

        return result;
    }

    public boolean canUndo() {
        return undoStack.size() > 0;
    }

    public boolean canRedo() {
        return redoStack.size() > 0;
    }

    public boolean undo() {
        boolean result = false;
        if (canUndo()) {
            ICommand command = undoStack.pop();
            redoStack.push(command);
            result = command.undo();
        }

        return result;
    }

    public boolean redo() {
        boolean result = false;
        if (canRedo()) {
            ICommand command = redoStack.pop();
            undoStack.push(command);
            result = command.redo();
        }

        return result;
    }
}