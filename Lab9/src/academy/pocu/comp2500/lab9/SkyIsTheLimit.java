package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SkyIsTheLimit implements IPricingModel {
    private final int MAX_SALE_QTY = 2;
    private int minTotalPrice;

    public SkyIsTheLimit(int minTotalPrice) {
        this.minTotalPrice = minTotalPrice;
    }

    @Override
    public int getTotalPrice(ArrayList<Book> books) {
        if (books == null) {
            return 0;
        }

        double totalPrice = new SimplePricing().getTotalPrice(books);

        if (totalPrice < minTotalPrice || books.size() < 5) {
            return (int) totalPrice;
        }

        var sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getPrice).reversed())
                .collect(Collectors.toCollection(ArrayList::new));

        totalPrice = 0;
        for (int i = 0; i < sortedBooks.size(); i++) {
            if (i < 2) {
                totalPrice += sortedBooks.get(i).getPrice() * 0.5;
            } else {
                totalPrice += sortedBooks.get(i).getPrice();
            }

        }

        return (int) totalPrice;
    }
}
