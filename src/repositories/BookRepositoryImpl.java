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

    public Book find(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> findAll() {
        return this.books;
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "books=" + books.toString() +
                '}';
    }
}
