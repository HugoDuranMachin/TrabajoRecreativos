public abstract class MenuOpcionesPremios extends DriverMenu {
    public static void menu() {

        resetStaticVariables();
        System.out.println("Actualmente hay " + stockPremios.listaPremios.size() + " premios");
        System.out.println("1 - Cargar premios por defecto (Sobreescribe)\n" +
                "2 - Añadir un premio\n" +
                "3 - Ver y Modificar premios\n" +
                "0 - Back");

        switchForMenu(input());
    }

    public static void switchForMenu(char selection) {

        switch (selection) {
            case '1':
                stockPremios = new StockPremios(1);
                menu();
                break;
            case '2':
                menuAddPremio();
                menu();
                break;
            case '3':
                selectPremioSaveVariables();
                menuModificarPremio(selectedPremio, indexPremioSelected);
                resetStaticVariables();
                break;
            default:
                DriverMenu.menu();
                break;
        }
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

    static void menuModificarPremio(Premio p, int index) {

        System.out.println("Que desea hacer con " + p + "? (Se aplica a todas las instancias de este premio)");

        System.out.println("1 - Eliminar el premio (ROMPE TODAS LAS TERMINALES INICIALIZADAS)\n" +
                "2 - Ver informacion sobre el premio\n" +
                "3 - Modificar el nombre del premio\n" +
                "4 - Modificar los tickets necesarios para canjear\n" +
                "5 - Modificar su stock\n" +
                "0 - Back");

        pointerToLastMenuAccessed = input();
        switchForMenuModificarPremio(pointerToLastMenuAccessed, p, index);
    }

    //TODO: pretty sure this can take no variables
     static void switchForMenuModificarPremio(char selection, Premio p, int index) {

        switch (selection) {
            case '1':
                stockPremios.listaPremios.remove(index);
                break;
            case '2':
                System.out.println(p.info());
                menuModificarPremio(p, index);
                break;
            case '3':
                p.setNombre(nuevoNombreParaPremio());
                menuModificarPremio(p, index);
                break;
            case '4':
                p.setTicketsNecesarios(nuevoPrecioParaPremio());
                menuModificarPremio(p, index);
                break;
            case '5':
                p.setStock(nuevoStockParaPremio());
                menuModificarPremio(p, index);
            default:
        }
        menu();

    }
}
