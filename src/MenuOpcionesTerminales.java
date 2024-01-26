public class MenuOpcionesTerminales extends DriverMenu {
    public static void menu() {

        resetStaticVariables();
        System.out.println("Actualmente hay " + listaTerminales.size() + " Terminales");
        System.out.println("1 - Cargar dos terminales\n" +
                "2 - Ver y Modificar Terminales\n" +
                "0 - Back");

        switch (input()) {
            case '1':
                addTerminal();
                addTerminal();
                menu();
            case '2':
                selectTerminalSaveVariables();
                modificarTerminal(selectedTerminal);
                resetStaticVariables();
                menu();
                break;
            default:
                break;
        }
        DriverMenu.menu();
    }

    public static void modificarTerminal(Terminal t) {

        System.out.println("Que desea hacer con " + t);
        System.out.println("1 - Eliminar la terminal\n" +
                "2 - Modificar los premios de la terminal\n" +
                "0 - Back");

        switch (input()) {
            case '1':
                listaTerminales.remove(indexTerminalSelected);
                //huh, clever, how did I manage
                verPagina(arrayTerminales(), 1);
                break;
            case '2':
                MenuPremiosEnTerminal.menu();
                break;
            default:
                break;
        }
        resetStaticVariables(); //paranoia
        menu();
    }
}
