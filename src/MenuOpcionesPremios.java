public class MenuOpcionesPremios {
    static Object[] arrayPremios() {return Main.stockPremios.listaPremios.toArray();}
    public static void menu() {

        System.out.println("Actualmente hay " + Main.stockPremios.listaPremios.size() + " premios");
        System.out.println("1 - Cargar premios por defecto (Sobreescribe)\n" +
                "2 - Añadir un premio\n" +
                "3 - Ver y Modificar premios\n" +
                "0 - Back");

        switchForMenu(Main.input());
    }

    public static void switchForMenu(char selection) {

        switch (selection) {
            case '1':
                Main.stockPremios = new StockPremios(1);
                menu();
            case '2':
                menuAddPremio();
            case '3':
                int indicePremioSeleccionado = (DriverMenu.seleccionDeItem(arrayPremios())-1);
                Premio premioSeleccionado = Main.stockPremios.listaPremios.get(indicePremioSeleccionado);
                menuModificarPremio(premioSeleccionado, indicePremioSeleccionado);
            default:
                menu();
        }
    }

    public static void menuAddPremio() {

        String nombrePremioNuevo = nuevoNombreParaPremio();
        Main.stockPremios.addPremio(nuevoNombreParaPremio(), nuevoStockParaPremio(), nuevoPrecioParaPremio());
        System.out.println("Premio añadido: " + nombrePremioNuevo);
        menu();
    }

    static String nuevoNombreParaPremio() {
        System.out.println("¿Nombre para el premio?\n" +
                "0 - Back\n");

        String buffer = Main.inputFull();
        if (buffer.charAt(0) == '0') {
            menu();
        }
        return buffer;
    }
    static int nuevoStockParaPremio() {

        System.out.println("¿Stock?\n" +
                "No he hecho que esto mire si es un número o no! Ahora mismo no me importa!\n");

        return Main.input() - 48;

    }
    static int nuevoPrecioParaPremio() {

        System.out.println("¿Precio?\n" +
                "No he hecho que esto mire si es un número o no! Ahora mismo no me importa!\n");

        return Main.input() -48;
        }

    public static void menuModificarPremio(Premio p, int index){

        System.out.println("Que desea hacer con " + p + "? (Se aplica a todas las instancias de este premio)");

        System.out.println("1 - Eliminar el premio (ROMPE TODAS LAS TERMINALES INICIALIZADAS)\n" +
                "2 - Modificar el nombre del premio\n" +
                "3 - Modificar los tickets necesarios para canjear\n" +
                "4 - Modificar su stock\n" +
                "0 - Back");

        DriverMenu.pointerToLastMenuAccessed = Main.input();
        switchForMenuModificarPremio(DriverMenu.pointerToLastMenuAccessed, p, index);
    }

    public static void switchForMenuModificarPremio(char selection, Premio p, int index) {

        switch (selection) {
            case '1':
                Main.stockPremios.listaPremios.remove(index);
                break;
            case '2':
                p.setNombre(nuevoNombreParaPremio());
            case '3':
                /*
                TODO: I was about here, idk
                 */
                menuModificarPremio(p, index);
            default:
        }
        menu();

    }

         //STOP
}
