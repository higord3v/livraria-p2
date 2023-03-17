import dtos.CreateBookDTO;
import entities.Book;
import entities.Taxes;
import repositories.BookRepositoryImpl;
import services.RegisterBookService;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static BookRepositoryImpl repository = new BookRepositoryImpl();
    public static void main(String[] args) {
        promptMainMenu();
    }

    private static void promptMainMenu () {

            Scanner sc = new Scanner(System.in);
            System.out.println("= = = = Bem-vindo(a) a Livraria P2 = = = =");
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Cadastrar um Livro");
            System.out.println("2 - Vender um Livro");
            System.out.println("3 - Imprimir Balanço");
            System.out.println("4 - Sair");
            System.out.println("");

            System.out.print("Opção: ");
            int optionPicked = sc.nextInt();



            if (optionPicked == 1) {
                promptCreateBookMenu();
            }else if (optionPicked == 2) {
                System.out.println("Livro vendido!");
                promptMainMenu();
            }else if (optionPicked == 3) {
                System.out.println("O balanço ainda não foi implementado");
                promptMainMenu();
            }else {
                System.out.println("Volte sempre!");
            }

            sc.close();
    }

    private static void promptCreateBookMenu() {
        Scanner sc = new Scanner(System.in);
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println("= = = = Cadastro de Livros = = = = ");
        System.out.print("Digite o nome do livro: ");
        String title = sc.nextLine();

        System.out.println("");
        System.out.print("Digite o preço unitário do livro: ");
        double price = sc.nextDouble();

        System.out.println("");
        System.out.print("Digite a quantidade de livros: ");
        int units = sc.nextInt();

        CreateBookDTO createBookDTO = new CreateBookDTO();
        createBookDTO.setPrice(price);
        createBookDTO.setTitle(title);
        createBookDTO.setUnits(units);
        RegisterBookService service = new RegisterBookService(repository);
        Book newBook = service.register(createBookDTO);

        System.out.println(newBook.units +" livros com o título "+ newBook.title +
                " custando "+ currencyFormatter.format(newBook.price) +" cadastrados com sucesso. ");

        // Impostos
        Taxes taxes = new Taxes(30, 5);
        double bookISS = (newBook.price * taxes.getISS())/ 100;
        double bookXLP = (newBook.price * taxes.getXLP())/ 100;
        double finalPrice = newBook.price + bookISS + bookXLP;

        System.out.println("Imposto por cada livro");
        System.out.println("Imposto ISS = "+ bookISS
                +" (30% do valor de cada livro)");
        System.out.println("Imposto XLP = "+ currencyFormatter.format(bookXLP)
                +" (5% do valor de cada livro)");
        System.out.println("Valor com impostos de cada livro é: "+ currencyFormatter.format(finalPrice));

        sc.next();
        promptMainMenu();
    }
}