import java.util.Scanner;

public class DriverMenu {

    static Scanner sc = new Scanner(System.in);

    public static void firstMenu() {
        System.out.println("1 - Cargar valores por defecto (Sobreescribe)\n" +
                           "2 - Modificar stock de premios\n" +
                           "3 - Modificar terminales\n" +
                           "4 - Modificar tarjetas (usuarios)\n" +
                           "5 - Iniciar Recreativas!\n" +
                           "0 - Exit");

        switch (sc.next().charAt(0)) {
            case '1':
                Main.loadDefaults();
                firstMenu();
            case '2':
                menuStockPremios();
            case '3':
                System.out.println("TODO"); break;
            case '4':
                menuTarjetas();
            case '0':
                break;
        }
    }


    public static void menuStockPremios() {

        System.out.println("Actualmente hay " + Main.stockPremios.listaPremios.size() + " premios");
        System.out.println("1 - Cargar premios por defecto (Sobreescribe)\n" +
                           "2 - Añadir un premio\n" +
                           "3 - Quitar un premio\n" +
                           "4 - Modificar un premio\n" +
                           "5 - Ver premios\n" +
                           "0 - Back");

        switch (sc.next().charAt(0)) {
            case '1':
                Main.stockPremios = new StockPremios(1);
                menuStockPremios();
            case '2':
                menuAddPremio();
            default:
                firstMenu();
        }

    }

    public static void menuAddPremio() {
        String nombrePremioNuevo;
        int stockPremioNuevo = Main.randomInt(20);
        int precioPremioNuevo = Main.randomInt(100);
        System.out.println("¿Nombre para el nuevo premio?\n" +
                           "0 - Back\n");

        String buffer = sc.next();
        if (buffer.charAt(0) == '0') {
            menuStockPremios();
        }
        nombrePremioNuevo = buffer;

        System.out.println("¿Stock?\n" +
                           "Cualquier cosa que no sea un numero - Aleatorio\n");

        buffer = sc.next();
        try {
            stockPremioNuevo = Integer.parseInt(buffer);
        } catch (Exception ignored) {
        }

        System.out.println("¿Precio?\n" +
                           "Cualquier cosa que no sea un numero - Aleatorio\n");
        try {
            precioPremioNuevo = Integer.parseInt(buffer);
        } catch (Exception ignored) {
        }

        Main.stockPremios.addPremio(nombrePremioNuevo, stockPremioNuevo, precioPremioNuevo);
        System.out.println("Premio añadido: " + nombrePremioNuevo);
        menuStockPremios();
    }

    public static void menuTarjetas() {

        System.out.println("1 - Cargar tres tarjetas\n" +
                           "2 - Ver y Modificar Tarjetas\n" +
                           "0 - Back");

        switch (sc.next().charAt(0)) {
            case '1':
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                menuTarjetas();
            case '2':
                verTarjetas();
                menuTarjetas();
            case '0':
                firstMenu();
        }
    }

    static int currentPage = 1;
    static int indexOfCardsInPage = 0;
    public static void verTarjetas() {
        int amountCards = Main.mapaTarjetas.size();
        int counter = 1;
        System.out.println("Pagina " + currentPage + " de " + (Main.mapaTarjetas.size() / 9 + 1));
        if (amountCards < indexOfCardsInPage + 7) {
            for (int i = indexOfCardsInPage; i < amountCards; i++) {
                System.out.println(counter + ": " + Main.mapaTarjetas.get(i));
                counter++;
            }
            System.out.println("8: Pagina Atras\n" +
                               "0: Exit Menu");
        } else {
            for (int i = indexOfCardsInPage; i < (indexOfCardsInPage + 7); i++) {
                System.out.println(counter + ": " + Main.mapaTarjetas.get(i));
                counter++;
            }
            System.out.println("8: Pagina Atras\n"+
                               "9: Pagina Siguiente\n" +
                               "0: Exit Menu");
        }
        paginacionTarjetas();
    }

    public static void paginacionTarjetas() {

        char buffer = sc.next().charAt(0);
        switch (buffer) {
            case '1': case '2': case '3': case '4':
            case '5': case '6': case '7':
                modificarTarjeta((buffer - 48));
                break;
            case '8':
                if (currentPage != 1) {
                    indexOfCardsInPage = indexOfCardsInPage - 7;
                    currentPage--;
                    verTarjetas();
                }
                System.out.println("No hay pagina anterior");
                paginacionTarjetas();
            case '9':
                if ((indexOfCardsInPage + 7) < Main.mapaTarjetas.size()) {
                    indexOfCardsInPage = indexOfCardsInPage + 7;
                    currentPage++;
                    verTarjetas();
                }
                System.out.println("No hay siguiente pagina");
                paginacionTarjetas();
            case '0': default:
                DriverMenu.menuTarjetas();
        }

    }

    public static void modificarTarjeta(int selection) {

        int adjustedUIDForOffset = (currentPage - 1) *7 + selection - 1; //Me salto el index 0 cada vez

        System.out.println("Que desea hacer con " + Main.mapaTarjetas.get(adjustedUIDForOffset));

        System.out.println("1 - Eliminar la tarjeta\n" +
                           "2 - Modificar su nombre\n" +
                           "0 - Back");

        switch (sc.next().charAt(0)) {
            case '1':
                Terminal.quitarTarjeta(adjustedUIDForOffset);
                verTarjetas();
            case '2':
                System.out.println("Escriba el nuevo nombre");
                sc.nextLine();
                Main.mapaTarjetas.get(adjustedUIDForOffset).setNombrePropietario(sc.nextLine());
                System.out.println("Informacion actualizada: " + Main.mapaTarjetas.get(adjustedUIDForOffset));
                verTarjetas();
            default:
                firstMenu();
        }
    }
}

