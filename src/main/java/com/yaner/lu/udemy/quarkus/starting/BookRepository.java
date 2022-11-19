package com.yaner.lu.udemy.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Foo", "Bar", 1998, genre),
                new Book(2, "Bar", "Foo", 2009, genre)
        );
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks()
                .stream()
                .filter(book -> book.id == id)
                .findFirst();
    }
}
