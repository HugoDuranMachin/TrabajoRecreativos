public class MenuOpcionesTarjetas {

    static Object[] arrayTarjetas() {
        return Main.mapaTarjetas.values().toArray();
    }

    public static void menu() {

        System.out.println("1 - Cargar tres tarjetas\n" +
                "2 - Ver y Modificar Tarjetas\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                menu();
            case '2':
                modificarTarjeta(DriverMenu.menuVerPaginacion(arrayTarjetas()));
            case '0':
                DriverMenu.menu();
        }
    }

    public static void modificarTarjeta(int selection) {

        selection = DriverMenu.indexOfItemInPage - (8 - selection);

        System.out.println("Que desea hacer con " + Main.mapaTarjetas.get(selection));

        System.out.println("1 - Eliminar la tarjeta\n" +
                "2 - Modificar su nombre\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Terminal.quitarTarjeta(selection);
                DriverMenu.menuVerPaginacion(arrayTarjetas());
            case '2':
                System.out.println("Escriba el nuevo nombre");
                Main.mapaTarjetas.get(selection).setNombrePropietario(Main.sc.nextLine());
                System.out.println("Informacion actualizada: " + Main.mapaTarjetas.get(selection));
                DriverMenu.resetSeleccionPagina();
                DriverMenu.menuVerPaginacion(arrayTarjetas());
            default:
                menu();
        }
    }
}
