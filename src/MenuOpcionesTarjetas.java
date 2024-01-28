public class MenuOpcionesTarjetas extends SeleccionYPaginacion {

    public static void menu() {

        System.out.println("Actualmente hay " + mapaTarjetas.size() + " tarjetas cargadas");
        System.out.println("1 - Cargar tres tarjetas\n" +
                "2 - Ver y Modificar Tarjetas\n" +
                "0 - Back");

        switch (inputChar()) {
            case '1':
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                Terminal.nuevaTarjeta();
                menu();
            case '2':
                selectPlayerSaveVariables();
                modificarTarjeta(indexPlayerSelected);
                resetStaticVariables();
                break;
            default:
        }
    }

    public static void modificarTarjeta(int index) {

        System.out.println("Que desea hacer con " + selectedPlayer);
        System.out.println("1 - Eliminar la tarjeta\n" +
                "2 - Modificar su nombre\n" +
                "0 - Back");

        switch (inputChar()) {
            case '1':
                Terminal.quitarTarjeta(index);
                //TODO: check if this breaks
                seleccionDeItem(arrayTarjetas());
            case '2':
                nuevoNombreParaTarjeta(selectedPlayer);
            default:
                break;
        }
    }

    public static void nuevoNombreParaTarjeta(Tarjeta t) {
        System.out.println("Escriba el nuevo nombre");
        t.setNombrePropietario(inputFull());
        System.out.println("Informacion actualizada: " + t);
    }
}
