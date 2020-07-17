package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
        Iterator<Integer> keys = booksByYear.keySet().iterator();
        while (keys.hasNext()) {
            var bookByYear = booksByYear.get(keys.next());
            if (bookByYear.size() > 1) {
                double price = bookByYear.stream()
                        .map(item -> item.getPrice())
                        .reduce(0, Integer::sum);
                totalPrice += price * 0.8;
            } else {
                totalPrice += bookByYear.get(0).getPrice();
            }
        }

        return (int) totalPrice;
    }
}