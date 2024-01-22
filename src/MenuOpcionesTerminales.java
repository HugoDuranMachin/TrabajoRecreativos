public class MenuOpcionesTerminales {


    static Object[] arrayTerminales(){
        return Main.listaTerminales.toArray();
    }

    public static void menu() {

        System.out.println("Actualmente hay " + Main.listaTerminales.size() + " Terminales");
        System.out.println("1 - Cargar dos terminales\n" +
                "2 - Ver y Modificar Terminales\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Main.addTerminal();
                Main.addTerminal();
                menu();
            case '2':
                modificarTerminal(DriverMenu.menuVerPaginacion(arrayTerminales()));
                menu();
            case '0':
                DriverMenu.menu();
        }
    }

    public static void modificarTerminal(int selection) {

        selection = DriverMenu.indexOfItemInPage - (8-selection);

        System.out.println("Que desea hacer con " + Main.listaTerminales.get(selection));

        System.out.println("1 - Eliminar la terminal\n" +
                "2 - Modificar los premios de la terminal\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Main.listaTerminales.remove(selection);
                DriverMenu.menuVerPaginacion(arrayTerminales());
            case '2':
                /*
                TODO: mover premios a su propio .java, terminar este menu, terminar la aplicacion
                 */
                
                System.out.println("menu de modificacion de items de terminal");
                DriverMenu.resetSeleccionPagina();
                DriverMenu.menuVerPaginacion(arrayTerminales());
            default:
                menu();
        }
    }
}
