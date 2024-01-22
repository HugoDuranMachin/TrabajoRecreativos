public class DriverMenu {

    static char pointerToLastMenuAccessed = 0;

    public static void menu() {
        System.out.println("1 - Cargar valores por defecto (Sobreescribe)\n" +
                           "2 - Modificar stock de premios\n" +
                           "3 - Modificar terminales\n" +
                           "4 - Modificar tarjetas (usuarios)\n" +
                           "5 - Iniciar Recreativas!\n" +
                           "0 - Exit");

        pointerToLastMenuAccessed = Main.input();
        optionsForMenu(pointerToLastMenuAccessed);
    }

    static void optionsForMenu(int selection) {
        switch (selection) {
            case '1':
                Main.loadDefaults();
                menu();
            case '2':
                MenuOpcionesPremios.menu();
            case '3':
                MenuOpcionesTerminales.menu();
            case '4':
                MenuOpcionesTarjetas.menu();
            case '0': default:
                break;
        }
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
        indexOfItemInPage += 7 - (obj.length % 7);
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
                optionsForMenu(pointerToLastMenuAccessed);
                break;
            case '1': case '2': case '3': case '4':
            case '5': case '6': case '7':
        }
        resetSeleccionPagina();
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
        if (indexOfItemInPage < obj.length) {
            currentPage++;
            menuVerPaginacion(obj);
        }
        System.out.println("No hay siguiente pagina");
        seleccionDeItemEnPagina(obj);
    }


}


