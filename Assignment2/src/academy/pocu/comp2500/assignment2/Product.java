package academy.pocu.comp2500.assignment2;

public class Product {
    protected int color;
    protected int price;
    protected ShipmentType shipmentType = ShipmentType.SHIP;

    protected void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public int getPrice() {
        return price;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }


}