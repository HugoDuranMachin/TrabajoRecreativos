import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class InformacionRecreativas {

    static int UID = 0;
    static StockPremios stockPremios = new StockPremios();
    static Map<Integer, Tarjeta> mapaTarjetas = new HashMap<>();
    static ArrayList<Terminal> listaTerminales = new ArrayList<>();
    static int indexPlayerSelected, indexTerminalSelected, indexPremioSelected;
    static Tarjeta selectedPlayer;
    static Terminal selectedTerminal;
    static Premio selectedPremio;
    static Tarjeta targetPlayer;
    static Scanner sc = new Scanner(System.in);

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
        if (isPrizeListEmpty()) {
            System.out.println("No hay premios que cargar en terminales! ERROR!");
            return;
        }
        listaTerminales.add(new Terminal(randomInt(10), stockPremios));
    }

    static char inputChar() {
        String buf = inputFull();
            return (buf.isEmpty()) ? inputChar() : buf.charAt(0);
    }

    static String inputFull() {
        String buf = sc.nextLine();
        return buf.isEmpty() ? inputFull() : buf;
    }

    static int inputInt(){
            try {
                return Integer.parseInt(inputFull());
            } catch (Exception ignored) {
                System.out.println("No has metido un numero");
            }
            return 0;
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

    static boolean isPrizeListEmpty() {
        return stockPremios.listaPremios.isEmpty();
    }

    static boolean isSourceAndTargetSame() {
        return selectedPlayer == targetPlayer;
    }

    static boolean isAPlayerSelected() {
        return (selectedPlayer != null);
    }

    static boolean isATerminalSelected() {
        return (selectedTerminal != null);
    }

    static boolean isAPrizeSelected() {
        return (selectedPremio != null);
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
