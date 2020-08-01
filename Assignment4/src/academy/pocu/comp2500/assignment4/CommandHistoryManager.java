package academy.pocu.comp2500.assignment4;

import java.util.Stack;

public class CommandHistoryManager {
    private final Canvas canvas;
    private final Stack<ICommand> commandHistory = new Stack<>();
    private final Stack<ICommand> redoHistory = new Stack<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        boolean result = command.execute(canvas);

        if (result) {
            commandHistory.push(command);
            redoHistory.clear();
        }

        return result;
    }

    public boolean canUndo() {
        return commandHistory.size() > 0;
    }

    public boolean canRedo() {
        return redoHistory.size() > 0;
    }

    public boolean undo() {
        boolean result = false;
        if (canUndo()) {
            ICommand command = commandHistory.pop();
            redoHistory.push(command);
            result = command.undo();
        }

        return result;
    }

    public boolean redo() {
        boolean result = false;
        if (canRedo()) {
            ICommand command = redoHistory.pop();
            commandHistory.push(command);
            result = command.redo();
        }

        return result;
    }
}
