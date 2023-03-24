package services;

import dtos.CreateBookDTO;
import entities.Book;
import entities.Taxes;
import repositories.BookRepository;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class RegisterBookService {
    BookRepository bookRepository;
    public RegisterBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void handle(Taxes taxes, Scanner sc) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println("= = = = Cadastro de Livros = = = = ");
        System.out.print("Digite o nome do livro: ");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.print("Digite o preço unitário do livro: ");
        double price = sc.nextDouble();

        System.out.println();
        System.out.print("Digite a quantidade de livros: ");
        int units = sc.nextInt();

        CreateBookDTO createBookDTO = new CreateBookDTO();
        createBookDTO.setPrice(price);
        createBookDTO.setTitle(title);
        createBookDTO.setUnits(units);
        Book newBook = this.bookRepository.create(createBookDTO);

        System.out.println(newBook.units +" livros com o título "+ newBook.title +
                " custando "+ currencyFormatter.format(newBook.price) +" cadastrados com sucesso. ");

        // Impostos
        double bookISS = (newBook.price * taxes.getISS())/ 100;
        double bookXLP = (newBook.price * taxes.getXLP())/ 100;
        double bookSAH = 0;
        if (newBook.price <= 150) {
            bookSAH = (newBook.price * taxes.getSAH(newBook.price))/100;
        }
        double finalPrice = newBook.price + bookISS + bookXLP + bookSAH;

        System.out.println("Imposto por cada livro");
        System.out.println("Imposto ISS = "+ currencyFormatter.format(bookISS)
                +" ("+taxes.getISS()+"% do valor de cada livro)");
        System.out.println("Imposto XLP = "+ currencyFormatter.format(bookXLP)
                +" ("+taxes.getXLP()+"% do valor de cada livro)");
        System.out.println("Imposto SAH = "+ currencyFormatter.format(bookSAH)
                +" ("+taxes.getSAH(newBook.price)+"% do valor de cada livro)");
        System.out.println("Valor com impostos de cada livro é: "+ currencyFormatter.format(finalPrice));
    }
}
