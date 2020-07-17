package academy.pocu.comp2500.lab9.App;

import academy.pocu.comp2500.lab9.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        SkyIsTheLimit model0 = new SkyIsTheLimit(50);
        SkyIsTheLimit model1 = new SkyIsTheLimit(100);
        SkyIsTheLimit model2 = new SkyIsTheLimit(150);

        Book book0 = new Book(UUID.randomUUID(), "Hello", 10, 1991);
        Book book1 = new Book(UUID.randomUUID(), "Hello", 15, 1995);
        Book book2 = new Book(UUID.randomUUID(), "Hello", 20, 1996);
        Book book3 = new Book(UUID.randomUUID(), "Hello", 25, 2011);
        Book book4 = new Book(UUID.randomUUID(), "Hello", 30, 2003);

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book0);
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);

        assert (model0.getTotalPrice(books1) == 70);
        assert (model1.getTotalPrice(books1) == 70);
        assert (model2.getTotalPrice(books1) == 70);

        ArrayList<Book> books2 = new ArrayList<>();
        books2.add(book0);
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);

        assert (model0.getTotalPrice(books2) == 72);
        assert (model1.getTotalPrice(books2) == 72);
        assert (model2.getTotalPrice(books2) == 100);

    }
}
