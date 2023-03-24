package repositories;

import dtos.CreateBookDTO;
import entities.Book;

import java.util.ArrayList;

public interface BookRepository {

    Book create(CreateBookDTO createBookDTO);
    Book find(String title);

    ArrayList<Book> findAll();
}
