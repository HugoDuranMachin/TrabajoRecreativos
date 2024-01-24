import java.util.*;
import java.util.Map;


public class Main {

    static int UID = 0;
    static public StockPremios stockPremios = new StockPremios();
    public static Map<Integer, Tarjeta> mapaTarjetas = new HashMap<>();
    static ArrayList<Terminal> listaTerminales = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static char input() {
        return sc.nextLine().charAt(0);
    }

    static String inputFull() {
        return sc.nextLine();
    }

    /*
    TODO:
        Puedes crear una tarjeta sin existir una terminal, porque son metodos estaticos
        No se si eso es lo que quiero.
     */

    public static void main(String[] args) {
        DriverMenu.menu();
    }

    public static void loadDefaults() {
        //Overwrite!
        stockPremios = new StockPremios(1);

        listaTerminales.clear();
        listaTerminales.add(new Terminal(3, stockPremios));
        listaTerminales.add(new Terminal(3, stockPremios));

        mapaTarjetas.clear();
        Terminal.nuevaTarjeta("Nombre1", randomInt(500));
        Terminal.nuevaTarjeta("Nombre2", randomInt(1000));
        Terminal.nuevaTarjeta("Nombre3", randomInt(1500));

    }

    public static int randomInt(int limit) {
        return (int) (Math.random() * limit);
    }

    public static void addTerminal() {
        listaTerminales.add(new Terminal(randomInt(10), stockPremios));
    }
}



