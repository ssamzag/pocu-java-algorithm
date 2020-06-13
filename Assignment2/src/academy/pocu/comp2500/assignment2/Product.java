package academy.pocu.comp2500.assignment2;

public class Product {
    protected int color;
    protected int price;
    protected ShipmentType shipment = ShipmentType.SHIP;
    
    public int getColor() {
        return this.color;
    }

    public int getPrice() {
        return price;
    }

    public ShipmentType getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentType shipment) {
        this.shipment = shipment;
    }
}