public class MenuPremiosEnTerminal extends MenuOpcionesTerminales {

    public static void menu() {
        System.out.println("Que desea hacer con " + selectedPremio + " con relacion a " + selectedTerminal);

        System.out.println("1 - Eliminar el premio DE LA TERMINAL\n" +
                "2 - Modificar los atributos del premio (GLOBAL)\n" +
                "0 - Back");

        switchForMenu(inputChar());
    }

    public static void switchForMenu(int selection) {
        
        switch (selection) {
            case '1':
                selectedTerminal.premiosEnTerminal.remove(indexPremioSelected);
                break;
            case '2':
                MenuModificarPremios.menu();
                switchForMenu(selection);
                return;
            default:
                return;
        }
        menu();
    }


    }

