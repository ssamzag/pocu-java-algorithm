package academy.pocu.comp2500.assignment2;

public class PrintLayout {
    private PrintLayoutType printLayoutType;

    public PrintLayout(PrintLayoutType type) {
        this.printLayoutType = type;
    }

    public PrintLayoutType getPrintLayoutType() {
        return this.printLayoutType;
    }

    protected void setLandscape() {
        this.printLayoutType = PrintLayoutType.LANDSCAPE;
    }

    protected void setPortrait() {
        this.printLayoutType = PrintLayoutType.PORTRAIT;
    }


}
