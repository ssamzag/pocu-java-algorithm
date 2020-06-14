package academy.pocu.comp2500.assignment2;

public class Product {
    protected int color;
    protected int price;
    protected int width;
    protected int height;
    protected ShipmentType shippingMethod;

    protected Product() {

    }

    public int getColor() {
        return this.color;
    }

    public int getPrice() {
        return price;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ShipmentType getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShipmentType shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

}