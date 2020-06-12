package academy.pocu.comp2500.lab6;

public class Menu {
    private int price;
    protected boolean isValid;

    public Menu(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
