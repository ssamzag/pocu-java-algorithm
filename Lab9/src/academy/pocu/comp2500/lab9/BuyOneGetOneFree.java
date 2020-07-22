package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class BuyOneGetOneFree implements IPricingModel {
    private final HashSet<UUID> skus = new HashSet<>();

    public BuyOneGetOneFree(HashSet<UUID> skus) {
        this.skus.addAll(skus);
    }

    @Override
    public int getTotalPrice(ArrayList<Book> books) {
        int price = 0;
        HashSet<UUID> existsSku = new HashSet<>();

        for (Book book : books) {
            if (skus.contains(book.getSku())) {
                if (existsSku.contains(book.getSku())) {
                    existsSku.remove(book.getSku());
                } else {
                    existsSku.add(book.getSku());
                    price += book.getPrice();
                }
            } else {
                price += book.getPrice();
            }
        }

        return price;
    }

}