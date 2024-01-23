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
                break;
            case '3':
                MenuOpcionesTerminales.menu();
                break;
            case '4':
                MenuOpcionesTarjetas.menu();
                break;
            case '0': default:
                return;
        }
        menu();
    }

    public static int currentPage = 1;

    public static int seleccionDeItem(Object[] obj) {
        verPagina(obj, currentPage);
        char selection = Main.input();
        switch (selection) {
            case '1': case '2': case '3': case '4':
            case '5': case '6': case '7':
                return selection-48;
            case '8':
                currentPage = currentPage-1;
                seleccionDeItem(obj);
                break;
            case '9':
                currentPage = currentPage+1;
                seleccionDeItem(obj);
                break;
            case '0': default:
                optionsForMenu(pointerToLastMenuAccessed);
                break;
        }
        return 0;
    }

    public static void verPagina(Object[] obj, int pagina) {
        int lastPage = (obj.length/7) + 1;
        if (pagina <= 0) {
            System.out.println("No hay página anterior");
            currentPage++;
            seleccionDeItem(obj);
        }

        if (pagina > lastPage) {
            System.out.println("No hay página siguiente");
            currentPage--;
            seleccionDeItem(obj);
        }

        verItemsEnPagina(obj, pagina);
    }

    public static void verItemsEnPagina(Object[] obj, int pagina) {
        int lastPage = (obj.length/7) + 1;
        boolean isLastPage = (pagina == lastPage);

        currentPage = pagina;
        int iteratedItemInPage = (pagina-1) * 7;
        int lastItemInPage = iteratedItemInPage + (isLastPage ? obj.length%7 : 7) ;

        System.out.println("Pagina: " + pagina + " de " + lastPage);

        for (int i = 0; iteratedItemInPage < lastItemInPage; i++) {
            System.out.println((i + 1) + ": " + obj[iteratedItemInPage]);
            iteratedItemInPage++;
        }

        System.out.println("8: Pagina Atras\n"+
                "9: Pagina Siguiente\n" +
                "0: Exit Menu");
    }
}


