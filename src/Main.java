import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
TODO:
Cargar creditos en cada tarjeta (Crear una opcion en el menu driver que cargue creditos)
Jugar a "varios juegos"
Transferir Creditos y Tickets
Intentar jugar y solicitar un premio con la tarjeta 1
*/
public class Main {

    static int UID = 0;
    static public StockPremios stockPremios = new StockPremios();
    public static Map<Integer, Tarjeta> mapaTarjetas = new HashMap<>();
    static ArrayList<Terminal> listaTerminales = new ArrayList<>();

    public static void main(String[] args) {

        DriverMenu.firstMenu();

    }

    public static void loadDefaults() {
        //Overwrite!
        stockPremios = new StockPremios(1);

        listaTerminales.clear();
        listaTerminales.add(new Terminal(3, stockPremios));
        listaTerminales.add(new Terminal(3, stockPremios));

        mapaTarjetas.clear();
        Terminal.nuevaTarjeta();
        Terminal.nuevaTarjeta();
        Terminal.nuevaTarjeta();

    }

    public static int randomInt(int limit) {
        return (int) (Math.random() * limit);
    }
}


