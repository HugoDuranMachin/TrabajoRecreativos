abstract class MenuOpcionesListaPremios extends SeleccionYPaginacion {
    public static void menu() {
        System.out.println("Actualmente hay " + stockPremios.listaPremios.size() + " premios");
        System.out.println("1 - Cargar premios por defecto (Sobreescribe)\n" +
                "2 - Añadir un premio\n" +
                "3 - Ver y Modificar premios\n" +
                "0 - Back");

        switchForMenu(inputChar());
    }

    public static void switchForMenu(char selection) {

        switch (selection) {
            case '1':
                stockPremios = new StockPremios(1);
                break;
            case '2':
                menuAddPremio();
                break;
            case '3':
                selectPremioSaveVariables();
                if (!isAPrizeSelected()) {
                    break;
                }
                MenuModificarPremios.menu();
                break;
            default:
                return;
        }
        menu();
    }

    //TODO: Maybe this should go inside the terminal?
    public static void menuAddPremio() {
        String nombrePremioNuevo = nuevoNombreParaPremio();
        stockPremios.addPremio(nombrePremioNuevo, nuevoStockParaPremio(), nuevoPrecioParaPremio());
        System.out.println("Premio añadido: " + nombrePremioNuevo);
    }

    static String nuevoNombreParaPremio() {
        System.out.println("¿Nombre para el premio?\n" +
                "(0 - Back)");
        String buffer = Main.inputFull();
        if (buffer.charAt(0) == '0') {
            menu();
        }
        return buffer;
    }

    static int nuevoStockParaPremio() {
        System.out.println("¿Stock?\n" +
                "No he hecho que esto mire si es un número o no! " +
                "Ahora mismo no me importa!\n" +
                "(0 - Back)");
        String buffer = Main.inputFull();
        if (buffer.charAt(0) == '0') {
            menu();
        }
        return Integer.parseInt(buffer);
    }

    static int nuevoPrecioParaPremio() {

        System.out.println("¿Precio?\n" +
                "No he hecho que esto mire si es un número o no! " +
                "Ahora mismo no me importa!\n");
        String buffer = Main.inputFull();
        if (buffer.charAt(0) == '0') {
            menu();
        }
        return Integer.parseInt(buffer);
    }
}


