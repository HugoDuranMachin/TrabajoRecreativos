public class DriverMenu {

    static int pointerToLastMenuAccessed = 0;

    public static void menu() {
        System.out.println("1 - Cargar valores por defecto (Sobreescribe)\n" +
                           "2 - Modificar stock de premios\n" +
                           "3 - Modificar terminales\n" +
                           "4 - Modificar tarjetas (usuarios)\n" +
                           "5 - Iniciar Recreativas!\n" +
                           "0 - Exit");

        pointerToLastMenuAccessed = Main.input();
        menuControlOpciones(pointerToLastMenuAccessed);
    }

    static void menuControlOpciones(int selection) {
        switch (selection) {
            case '1':
                Main.loadDefaults();
                menu();
            case '2':
                menuOpcionesPremios();
            case '3':
                MenuOpcionesTerminales.menu();
            case '4':
                MenuOpcionesTarjetas.menu();
            case '0': default:
                break;
        }
    }

    public static void menuOpcionesPremios() {

        System.out.println("Actualmente hay " + Main.stockPremios.listaPremios.size() + " premios");
        System.out.println("1 - Cargar premios por defecto (Sobreescribe)\n" +
                           "2 - Añadir un premio\n" +
                           "3 - Ver y Modificar premios\n" +
                           "0 - Back");

        switch (Main.input()) {
            case '1':
                Main.stockPremios = new StockPremios(1);
                menuOpcionesPremios();
            case '2':
                menuAddPremio();
            case '3':
            default:
                menu();
        }
    }

    public static void menuAddPremio() {
        String nombrePremioNuevo;
        int stockPremioNuevo = Main.randomInt(20);
        int precioPremioNuevo = Main.randomInt(100);
        System.out.println("¿Nombre para el nuevo premio?\n" +
                           "0 - Back\n");

        String buffer = Main.sc.next();
        if (buffer.charAt(0) == '0') {
            menuOpcionesPremios();
        }
        nombrePremioNuevo = buffer;

        System.out.println("¿Stock?\n" +
                           "Cualquier cosa que no sea un numero - Aleatorio\n");

        buffer = Main.sc.next();
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
        menuOpcionesPremios();
    }

    public static void menuVerPremios() {

    }


    public static int currentPage = 1;
    public static int indexOfItemInPage = 0;

    public static void resetSeleccionPagina() {
        indexOfItemInPage = 0;
        currentPage = 1;
    }

    public static int menuVerPaginacion(Object[] obj) {
        System.out.println("Pagina " + currentPage + " de " + (obj.length / 9 + 1));
        boolean hayMasDeSieteItemsAMostrar = obj.length >= indexOfItemInPage + 7;
        if (hayMasDeSieteItemsAMostrar) {
            verItemsPagina(obj);
        } else {
            verItemsPaginaUltima(obj);
        }
        return seleccionDeItemEnPagina(obj);
    }

    public static void verItemsPagina(Object[] obj) {
        for (int i = indexOfItemInPage + 7; i > indexOfItemInPage; indexOfItemInPage++) {
            System.out.println(indexOfItemInPage %7+1 + ": " + obj[indexOfItemInPage]);
        }
        System.out.println("8: Pagina Atras\n"+
                "9: Pagina Siguiente\n" +
                "0: Exit Menu");
    }

    public static void verItemsPaginaUltima(Object[] obj) {
        while (indexOfItemInPage < obj.length) {
            System.out.println(indexOfItemInPage %7+1 + ": " + obj[indexOfItemInPage]);
            indexOfItemInPage++;
        }
        System.out.println("8: Pagina Atras\n" +
                "0: Exit Menu");
    }

    public static int seleccionDeItemEnPagina(Object[] obj) {

        char selection = Main.input();
        switch (selection) {
            case '8':
                paginaAnterior(obj);
                break;
            case '9':
                paginaSiguiente(obj);
                break;
            case '0': default:
                resetSeleccionPagina();
                menuControlOpciones(pointerToLastMenuAccessed);
                break;
            case '1': case '2': case '3': case '4':
            case '5': case '6': case '7':
        }
        return selection-48;
    }

    private static void paginaAnterior(Object[] obj) {
        if (currentPage != 1) {
            indexOfItemInPage = indexOfItemInPage -14;
            currentPage--;
            menuVerPaginacion(obj);
        }
        System.out.println("No hay pagina anterior");
        seleccionDeItemEnPagina(obj);
    }

    private static void paginaSiguiente(Object[] obj) {
        if (indexOfItemInPage < Main.mapaTarjetas.size()) {
            currentPage++;
            menuVerPaginacion(obj);
        }
        System.out.println("No hay siguiente pagina");
        seleccionDeItemEnPagina(obj);
    }


}


