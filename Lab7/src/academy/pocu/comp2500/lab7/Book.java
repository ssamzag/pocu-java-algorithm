package academy.pocu.comp2500.lab7;

import java.util.Objects;

public class Book {
    private String title;
    private Author author;
    private int publicationYear;
    private Genre genre;

    public Book(String title, Author author, int publicationYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.publicationYear == book.publicationYear &&
                this.title.equals(book.title) &&
                this.author.equals(book.author) &&
                this.genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear, genre);
    }
}
