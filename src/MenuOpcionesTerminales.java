public class MenuOpcionesTerminales {

    static Object[] arrayTerminales() {
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
                modificarTerminal(DriverMenu.seleccionDeItem(arrayTerminales()));
                menu();
            case '0':
                DriverMenu.menu();
        }
    }

    public static void modificarTerminal(int indexTerminal) {
        Terminal terminalSeleccionada = Main.listaTerminales.get(indexTerminal);
        Object[] premiosDeTerminalT = terminalSeleccionada.premiosEnTerminal.toArray();
        int indexDePremioSeleccionado;

        System.out.println("Que desea hacer con " + terminalSeleccionada);

        System.out.println("1 - Eliminar la terminal\n" +
                "2 - Modificar los premios de la terminal\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Main.listaTerminales.remove(indexTerminal);
                DriverMenu.verPagina(arrayTerminales(), 1);
                break;
            case '2':
                indexDePremioSeleccionado = (DriverMenu.seleccionDeItem(premiosDeTerminalT));
                Premio premioSeleccionado = terminalSeleccionada.premiosEnTerminal.get(indexDePremioSeleccionado);
                MenuPremiosEnTerminal.menu(
                        premioSeleccionado,
                        terminalSeleccionada,
                        indexDePremioSeleccionado,
                        indexTerminal
                );
                break;
            default:
                menu();
        }
    }
}
