package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (var product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
