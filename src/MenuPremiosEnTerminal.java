import java.util.ArrayList;

public class MenuPremiosEnTerminal extends MenuOpcionesTerminales {

    public static void menu(int indexPremioSeleccionado, Premio selectedPremio) {

        Object[] premiosForT = arrayPremiosEnTerminal(selectedTerminal);

        System.out.println("Que desea hacer con " + selectedPremio + " con relacion a " + selectedTerminal);

        System.out.println("1 - Eliminar el premio DE LA TERMINAL\n" +
                "2 - Modificar los atributos del premio (GLOBAL)\n" +
                "0 - Back");

        switchForMenu(input(), selectedTerminal.premiosEnTerminal);
    }

    public static void switchForMenu(int selection, ArrayList<Premio> premiosEnTerminal) {
        
        switch (selection) {
            case '1':
                premiosEnTerminal.remove(indexPremioSelected);
                modificarTerminal(selectedTerminal);
                break;
            case '2':
                MenuOpcionesPremios.menuModificarPremio(selectedPremio, indexPremioSelected);
                switchForMenu(selection, premiosEnTerminal);
                break;
            default:
                resetStaticVariables();
                break;}

        modificarTerminal(selectedTerminal);

    }


    }

