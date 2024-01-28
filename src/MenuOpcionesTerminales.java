public class MenuOpcionesTerminales extends SeleccionYPaginacion {
    public static void menu() {

        System.out.println("Actualmente hay " + listaTerminales.size() + " Terminales");
        System.out.println("1 - Cargar dos terminales\n" +
                "2 - Ver y Modificar Terminales\n" +
                "0 - Back");

        switch (inputChar()) {
            case '1':
                addTerminal();
                addTerminal();
                break;
            case '2':
                selectTerminalSaveVariables();
                if (!isATerminalSelected()) {
                    break;
                }
                modificarTerminal(selectedTerminal);
                break;
            default:
                return;
        }
        menu();
    }

    public static void modificarTerminal(Terminal t) {

        System.out.println("Que desea hacer con " + t);
        System.out.println("1 - Eliminar la terminal\n" +
                "2 - Modificar los premios de la terminal\n" +
                "0 - Back");

        switch (inputChar()) {
            case '1':
                listaTerminales.remove(indexTerminalSelected);
                return;
            case '2':
                selectPremioFromTerminalSaveVariables(t);
                if (!isAPrizeSelected()) {
                    break;
                }
                MenuPremiosEnTerminal.menu();
                break;
            default:
                return;
        }
        modificarTerminal(t);
    }
}
