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
                modificarTarjeta(DriverMenu.seleccionDeItem(arrayTarjetas()));
            case '0':
                DriverMenu.menu();
        }
    }

    public static void modificarTarjeta(int selection) {

        System.out.println("Que desea hacer con " + Main.mapaTarjetas.get(selection));

        System.out.println("1 - Eliminar la tarjeta\n" +
                "2 - Modificar su nombre\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Terminal.quitarTarjeta(selection);
                DriverMenu.seleccionDeItem(arrayTarjetas());
            case '2':
                System.out.println("Escriba el nuevo nombre");
                Main.mapaTarjetas.get(selection).setNombrePropietario(Main.inputFull());
                System.out.println("Informacion actualizada: " + Main.mapaTarjetas.get(selection));
                DriverMenu.seleccionDeItem(arrayTarjetas());
            default:
                menu();
        }
    }
}
