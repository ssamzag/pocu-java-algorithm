package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;

public class DecadeMadness implements IPricingModel {
    @Override
    public int getTotalPrice(ArrayList<Book> books) {
        HashMap<Integer, ArrayList<Book>> booksByYear = new HashMap<>();

        for (Book book : books) {
            int year = book.getPublishedYear() - book.getPublishedYear() % 10;
            var bookByYear = booksByYear.get(year);

            if (bookByYear == null) {
                var bookArrayList = new ArrayList<Book>();
                bookArrayList.add(book);
                booksByYear.put(year, bookArrayList);
            } else {
                bookByYear.add(book);
            }
        }

        double totalPrice = 0;
        for (Integer integer : booksByYear.keySet()) {
            var bookByYear = booksByYear.get(integer);
            if (bookByYear.size() > 1) {
                double price = bookByYear.stream()
                        .map(Book::getPrice)
                        .reduce(0, Integer::sum);
                totalPrice += price * 0.8;
            } else {
                totalPrice += bookByYear.get(0).getPrice();
            }
        }

        return (int) totalPrice;
    }
}