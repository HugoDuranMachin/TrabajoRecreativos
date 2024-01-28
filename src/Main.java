import java.util.*;
public class Main {

    static int UID = 0;
    static StockPremios stockPremios = new StockPremios();
    static Map<Integer, Tarjeta> mapaTarjetas = new HashMap<>();
    static ArrayList<Terminal> listaTerminales = new ArrayList<>();
    static int indexPlayerSelected, indexTerminalSelected, indexPremioSelected;
    static Tarjeta selectedPlayer;
    static Terminal selectedTerminal;
    static Premio selectedPremio;
    static Scanner sc = new Scanner(System.in);
    static String lastUserInput = null;

    public static void main(String[] args) {
        mainMenu();
        System.out.println("Byebye!");
    }

     static void mainMenu() {
            System.out.println("1 - Cargar valores por defecto (Sobreescribe)\n" +
                    "2 - Modificar stock de premios\n" +
                    "3 - Modificar terminales\n" +
                    "4 - Modificar tarjetas (usuarios)\n" +
                    "5 - Iniciar Recreativas!\n" +
                    "0 - Exit");

            optionsForMenu(inputChar());
        }

    static void optionsForMenu(int input) {
        switch (input) {
            case '1':
                loadDefaults();
                break;
            case '2':
                MenuOpcionesPremios.menu();
                break;
            case '3':
                MenuOpcionesTerminales.menu();
                break;
            case '4':
                MenuOpcionesTarjetas.menu();
                break;
            case '5':
                MenuRecreativas.menu();
                break;
            case '0':
            default:
                return;
        }
            mainMenu();
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

    static char inputChar() {
        inputFull();
        return lastUserInput.charAt(0);
    }

    static String inputFull() {
        lastUserInput = sc.nextLine();
        return lastUserInput;
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



