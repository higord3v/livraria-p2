package repositories;

import dtos.CreateBookDTO;
import entities.Book;

public interface BookRepository {

    Book create(CreateBookDTO createBookDTO);
}
