package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    private void addProduct(Product product) {
        this.products.add(product);
    }

    private void removeProduct(Product product) {
        this.products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (var product : products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }
}
