package academy.pocu.comp2500.assignment2;

import java.awt.Color;

public class Product {
    private int price;
    private int color;
    private PrintSize printSize;
    private PrintLayoutType printLayoutType;

    protected PrintSize getPrintSize() {
        return this.printSize;
    }

    protected void setPrintSize(PrintSize size){
        this.printSize = size;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected PrintLayoutType getPrintLayoutType() {
        return this.printLayoutType;
    }

    protected void setPrintLayoutType(PrintLayoutType type) {
        this.printLayoutType = type;
    }

    protected void setColor(int color) {
        this.color = color;
    }

    protected int getColor() {
        return this.color;
    }
}
