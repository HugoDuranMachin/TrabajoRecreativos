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
        System.out.println("La terminal es de index " + indexTerminal);
        System.out.println("Que desea hacer con " + p + " con relacion a " + t);

        System.out.println("1 - Eliminar el premio DE LA TERMINAL\n" +
                "2 - Modificar los atributos del premio (GLOBAL)\n" +
                "0 - Back");

        switchForMenu(Main.input());
    }

    public static void switchForMenu(int selection) {

        switch (selection) {
            case '1':
                terminalSelected.premiosEnTerminal.remove(indexPremio);
                MenuOpcionesTerminales.modificarTerminal(indexTerminal);
                break;
            case '2':
                MenuOpcionesPremios.menuModificarPremio(premioSelected, indexPremio);
                switchForMenu(selection);
                break;
            default:
                MenuOpcionesTerminales.modificarTerminal(Main.listaTerminales.indexOf(terminalSelected));
        }
    }


    }

