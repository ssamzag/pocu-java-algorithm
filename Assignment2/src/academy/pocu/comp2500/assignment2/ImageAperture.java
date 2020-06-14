package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    protected String imagePath;

    public ImageAperture(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);
        this.imagePath = imagePath;
        super.isValid = !imagePath.equals("");
    }

    public String getImagePath() {
        return imagePath;
    }
}
