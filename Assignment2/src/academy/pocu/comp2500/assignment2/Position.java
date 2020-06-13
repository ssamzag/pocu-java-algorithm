package academy.pocu.comp2500.assignment2;

public class Position {
    private int x;
    private int y;
    private String word;

    public Position(String word, int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getWord() {
        return word;
    }
}
