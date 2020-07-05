package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.Objects;

public class Bundle {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public Bundle(String name) {
        this.name = name;
    }

    public boolean add(Book book) {
        if (book == null) {
            return false;
        }
        return this.books.add(book);
    }

    public boolean remove(Book book) {
        return this.books.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        Bundle bundle = (Bundle) o;
        return this.name.equals(bundle.name) && this.books.equals(bundle.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}