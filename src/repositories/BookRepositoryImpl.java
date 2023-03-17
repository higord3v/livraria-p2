package repositories;

import dtos.CreateBookDTO;
import entities.Book;
import java.util.ArrayList;

public class BookRepositoryImpl implements BookRepository {
    public ArrayList<Book> books = new ArrayList<Book>();

    public Book create(CreateBookDTO createBookDTO) {
        Book newBook = new Book(createBookDTO.getTitle(), createBookDTO.getPrice(), createBookDTO.getUnits());
        books.add(newBook);
        return newBook;
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "books=" + books.toString() +
                '}';
    }
}
