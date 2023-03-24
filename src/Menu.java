import entities.Taxes;
import repositories.BookRepositoryImpl;
import services.SellBookService;
import services.ShowBalanceService;
import services.RegisterBookService;

import java.util.Scanner;

public class Menu {
    private static BookRepositoryImpl repository = new BookRepositoryImpl();
    private static RegisterBookService registerBookService = new RegisterBookService(repository);
    private static ShowBalanceService showBalanceService = new ShowBalanceService(repository);
    private static SellBookService sellBookService = new SellBookService(repository);
    private static Taxes taxes = new Taxes();

    public void promptMainMenu () {

        Scanner sc = new Scanner(System.in);
        System.out.println("= = = = Bem-vindo(a) a Livraria P2 = = = =");
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Cadastrar um Livro");
        System.out.println("2 - Vender um Livro");
        System.out.println("3 - Imprimir Balanço");
        System.out.println("4 - Alterar porcentagem dos impostos");
        System.out.println("5 - Sair");
        System.out.println();

        System.out.print("Opção: ");
        int optionPicked = sc.nextInt();



        if (optionPicked == 1) {
            promptCreateBookMenu(sc);
        }else if (optionPicked == 2) {
            promptSellBookMenu(sc);
            promptMainMenu();
        }else if (optionPicked == 3) {
            promptBalanceMenu(sc);
        }else if (optionPicked == 4){
            promptChangeTaxesMenu(sc);
        }else {
            System.out.println("Volte sempre!");
        }
        sc.close();
    }

    protected void promptCreateBookMenu(Scanner sc) {
        registerBookService.handle(taxes, sc);
        System.out.println();
        System.out.println("Digite [qualquer tecla] + enter para voltar ao menu");
        sc.next();
        promptMainMenu();
    }

    protected void promptSellBookMenu(Scanner sc) {
        sellBookService.handle(sc);
        System.out.println("");
        System.out.println("Digite [qualquer tecla] + enter para voltar ao menu");
        sc.next();
        promptMainMenu();
    }

    protected void promptBalanceMenu(Scanner sc) {
        showBalanceService.handle();
        System.out.println();
        System.out.println("Digite [qualquer tecla] + enter para voltar ao menu");
        sc.next();
        promptMainMenu();
    }

    protected void promptChangeTaxesMenu(Scanner sc) {
        System.out.println("= = = = Imposto de Livros = = = =");

        System.out.print("Digite a porcentagem do ISS:");
        int newISSValue = sc.nextInt();
        System.out.println();

        System.out.println("Digite a porcentagem do XLP:");
        int newXLPValue = sc.nextInt();

        taxes.setISS(newISSValue);
        taxes.setXLP(newXLPValue);

        System.out.println("Imposto ISS alterado para ("+ taxes.getISS()+"% do valor de cada livro)");
        System.out.println("Imposto XLP alterado para ("+ taxes.getXLP()+"% do valor de cada livro)");
        System.out.println();
        System.out.println("Aperte qualquer tecla+enter para voltar ao MENU");
        sc.next();

        promptMainMenu();
    }
}
