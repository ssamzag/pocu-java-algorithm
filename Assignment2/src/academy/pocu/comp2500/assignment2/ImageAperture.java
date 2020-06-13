package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    protected String imagePath;

    public ImageAperture(int x, int y, String imagePath) {
        super(x, y);
        this.imagePath = imagePath;
    }

}
