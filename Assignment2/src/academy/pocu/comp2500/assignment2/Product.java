package academy.pocu.comp2500.assignment2;

public class Product {
    protected int color;
    protected int price;
    protected ShipmentType shippingMethod = ShipmentType.SHIP;

    public int getColor() {
        return this.color;
    }

    public int getPrice() {
        return price;
    }

    public ShipmentType getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShipmentType shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}