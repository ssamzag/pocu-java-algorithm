package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private final char c;
    private boolean canExecute = true;
    private Canvas canvas;
    private char beforePixelWord;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canExecute) {
            this.beforePixelWord = canvas.getPixel(this.x, this.y);
            canvas.drawPixel(this.x, this.y, this.c);
            canExecute = false;
            return true;
        }

        return false;
    }

    @Override
    public boolean undo() {
        canvas.drawPixel(this.x, this.y, beforePixelWord);
        return false;
    }

    @Override
    public boolean redo() {
        canvas.drawPixel(this.x, this.y, c);
        return false;
    }
}
