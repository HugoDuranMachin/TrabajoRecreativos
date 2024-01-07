import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Terminal> indiceTerms = new ArrayList<>();
    static StockPremios sp = new StockPremios();
    
    static char input() {
        return sc.next().charAt(0);
    }

    public static void firstMenu() {
        System.out.println("""
                1 - Cargar valores por defecto (Sobreescribe)
                2 - Modificar stock de premios
                3 - Modificar terminales
                0 - Exit""");

        switch (input()) {
            case '1':
                loadDefaults();
                firstMenu();
            case '2':
                menuStockPremios();
            case '0':
                break;
        }
    }

    public static void loadDefaults() {
        //Overwrite!
        sp = new StockPremios(1); menuStockPremios();
        indiceTerms.add(new Terminal(3, sp));
        indiceTerms.add(new Terminal(3, sp));
    }

    public static void menuStockPremios() {

        System.out.println("Actualmente hay " + sp.listaPremios.size() + " premios");
        System.out.println("""
                1 - Cargar premios por defecto (Sobreescribe)
                2 - Añadir un premio
                3 - Quitar un premio
                4 - Modificar un premio
                0 - Back""");

        switch (input()) {
            case '1':
                sp = new StockPremios(1); menuStockPremios();
            case '2':
                //TODO: aaehghhh
        }

    }
}
