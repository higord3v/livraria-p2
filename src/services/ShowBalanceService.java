package services;

import entities.Book;
import repositories.BookRepository;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ShowBalanceService {
    private BookRepository repository;

    public ShowBalanceService(BookRepository repository) {
        this.repository = repository;
    }

    public void handle() {
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        ArrayList<Book> books = repository.findAll();
        int totalRevenue = 0;
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            System.out.println((i + 1) + ")Livro: "
            + currentBook.title
            + ", Quantidade: "
            + currentBook.units
            + ", Valor unitário "
            + currencyFormatter.format(currentBook.price));
            totalRevenue += currentBook.price * currentBook.selledUnits;
        }
        System.out.println("Total arrecadado em vendas: "
                + currencyFormatter
                .format(totalRevenue));
    }
}
