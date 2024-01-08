import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Terminal> indiceTerms = new ArrayList<>();
    static public StockPremios sp = new StockPremios();

    public static void firstMenu() {
        System.out.println("""
                1 - Cargar valores por defecto (Sobreescribe)
                2 - Modificar stock de premios
                3 - Modificar terminales
                0 - Exit""");

        switch (sc.next().charAt(0)) {
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
                5 - Ver premios
                0 - Back""");

        switch (sc.next().charAt(0)) {
            case '1':
                sp = new StockPremios(1); menuStockPremios();
            case '2':
                menuAddPremio();
        }

    }

    public static void menuAddPremio() {
        //should never occur
        String nombrePremioNuevo = "unnamed" + sp.listaPremios.size();
        int stockPremioNuevo = myMethods.randomInt(20);
        int precioPremioNuevo = myMethods.randomInt(100);
        System.out.println("""
                ¿Nombre para el nuevo premio?
                0 - Back
                """);

        String buffer = sc.next();
        switch (buffer.charAt(0)) {
            case '0': menuStockPremios();
            default: nombrePremioNuevo = buffer;
        }

        System.out.println("""
                ¿Stock?
                Cualquier cosa que no sea un numero - Aleatorio
                """);

        buffer = sc.next();
        try {
            stockPremioNuevo = Integer.valueOf(buffer);
        } catch (Exception e) {
        }

        System.out.println("""
                ¿Precio?
                Cualquier cosa que no sea un numero - Aleatorio
                """);
        try {
            precioPremioNuevo = Integer.valueOf(buffer);
        } catch (Exception e) {
        }

        sp.addPremio(nombrePremioNuevo, stockPremioNuevo, precioPremioNuevo);
        System.out.println("Premio añadido: " + nombrePremioNuevo);
        menuStockPremios();
    }



}
