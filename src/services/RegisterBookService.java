package services;

import dtos.CreateBookDTO;
import entities.Book;
import repositories.BookRepository;

public class RegisterBookService {
    BookRepository bookRepository;
    public RegisterBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book register(CreateBookDTO createBookDTO) {
        return this.bookRepository.create(createBookDTO);
    }
}
