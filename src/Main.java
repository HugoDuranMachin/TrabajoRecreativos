import java.util.*;
public class Main {

    static int UID = 0;
    static StockPremios stockPremios = new StockPremios();
    static Map<Integer, Tarjeta> mapaTarjetas = new HashMap<>();
    static ArrayList<Terminal> listaTerminales = new ArrayList<>();
    static Tarjeta selectedPlayer;
    static int indexPlayerSelected;
    static Terminal selectedTerminal;
    static int indexTerminalSelected;
    static Premio selectedPremio;
    static int indexPremioSelected;
    static Scanner sc = new Scanner(System.in);
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

    static char input() {
        return sc.nextLine().charAt(0);
    }

    static String inputFull() {
        return sc.nextLine();
    }

    static Object[] arrayPremios() {
        return stockPremios.listaPremios.toArray();
    }
    static Object[] arrayTerminales() {
        return listaTerminales.toArray();
    }
    static Object[] arrayTarjetas() {
        return mapaTarjetas.values().toArray();
    }

    static Object[] arrayPremiosEnTerminal(Terminal t) {
        return t.premiosEnTerminal.toArray();
    }

    static void resetStaticVariables() {
        selectedPlayer = null;
        indexPlayerSelected = 0;
        selectedTerminal = null;
        indexTerminalSelected = 0;
        selectedPremio = null;
        indexPremioSelected = 0;
    }


}



