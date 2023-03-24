package services;

import entities.Book;
import repositories.BookRepository;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SellBookService {
    private BookRepository bookRepository;
    public SellBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void handle(Scanner sc) {
        System.out.println("= = = = Venda de Livros = = = = ");
        System.out.print("Digite o nome do livro: ");
        sc.nextLine();
        String bookTyped = sc.nextLine();
        Book findedBook = bookRepository.find(bookTyped);
        if (findedBook == null) {
            System.out.println("O livro buscado não foi cadastrado");
            System.out.println("Digite [qualquer tecla] + enter para voltar ao menu");
            sc.next();
            return;
        }
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println("==> "+ findedBook.title + " custa "
                + currencyFormatter.format(findedBook.price));

        System.out.print("Digite a quantidade que deseja vender: ");
        int units = sc.nextInt();
        if (units > findedBook.units) {
            System.out.println("Não é possível vender pois não há "+ units + " do livro "
                    + findedBook.title
                    + " no estoque"
            );
            return;
        }
        findedBook.units = findedBook.units - units;
        findedBook.selledUnits = units;
        System.out.println("==> Total arrecadado: "
                + currencyFormatter
                .format(findedBook.price * units));

    }
}
