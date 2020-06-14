package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private String text;

    public TextAperture(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
        super.isValid = !text.equals("");
    }

    public String getText() {
        return text;
    }

}
