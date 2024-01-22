public class MenuEditarPremiosEnTerminal {

    static Terminal terminalSelected;
    static Premio premioSelected;
    static int indexPremio;
    static int indexTerminal;
    public static void menu(Premio p, Terminal t, int iPremio, int iTerminal) {

        terminalSelected = t;
        premioSelected = p;
        indexPremio = iPremio;
        indexTerminal = iTerminal;
        System.out.println("Que desea hacer con " + p + "Con relacion a " + t);

        System.out.println("1 - Eliminar el premio DE LA TERMINAL\n" +
                "2 - Modificar los atributos del premio (GLOBAL)\n" +
                "0 - Back");

        DriverMenu.pointerToLastMenuAccessed = Main.input();
        switchForMenu(DriverMenu.pointerToLastMenuAccessed);
    }

    public static void switchForMenu(int selection) {

        switch (selection) {
            case '1':
                terminalSelected.premiosEnTerminal.remove(indexPremio);
            case '2':
                System.out.println("menu de modificacion de un premio de la terminal");
                MenuOpcionesPremios.menuModificarPremio(premioSelected, indexPremio);
                DriverMenu.resetSeleccionPagina();
                switchForMenu(selection);
            default:
                MenuOpcionesTerminales.modificarTerminal(Main.listaTerminales.indexOf(terminalSelected));
        }
    }


    }

