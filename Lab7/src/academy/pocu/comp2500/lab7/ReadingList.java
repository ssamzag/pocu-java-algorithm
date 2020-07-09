package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.Objects;

public class ReadingList {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public ReadingList(String name) {
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
    public String toString() {
        StringBuilder readingList = new StringBuilder();
        for (int i = 0; i < this.books.size(); i++) {
            readingList.append(String.format("%d. %s%s", i + 1, books.get(i), System.lineSeparator()));
        }

        return readingList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        ReadingList readingList = (ReadingList) o;
        return this.name.equals(readingList.name) &&
                this.books.equals(readingList.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}
