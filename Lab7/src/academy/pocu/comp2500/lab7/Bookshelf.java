package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.Objects;

public class Bookshelf {
    private int maxBooks;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public boolean add(Book book) {
        if (book == null || this.maxBooks == this.books.size()) {
            return false;
        }

        return this.books.add(book);
    }

    public boolean remove(Book book) {
        return this.books.remove(book);
    }
}
