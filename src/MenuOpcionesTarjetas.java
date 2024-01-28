class MenuOpcionesTarjetas extends SeleccionYPaginacion {

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
                break;
            case '2':
                selectPlayerSaveVariables();
                modificarTarjeta(indexPlayerSelected);
                break;
            default:
                return;
        }
        menu();
    }

    public static void modificarTarjeta(int index) {

        System.out.println("Que desea hacer con " + selectedPlayer);
        System.out.println("1 - Eliminar la tarjeta\n" +
                "2 - Modificar su nombre\n" +
                "0 - Back");

        switch (inputChar()) {
            //Huh, both early return
            case '1':
                Terminal.quitarTarjeta(index);
                return;
            case '2':
                nuevoNombreParaTarjeta(selectedPlayer);
                return;
            default:
        }
    }

    public static void nuevoNombreParaTarjeta(Tarjeta t) {
        System.out.println("Escriba el nuevo nombre");
        t.setNombrePropietario(inputFull());
        System.out.println("Informacion actualizada: " + t);
    }
}
