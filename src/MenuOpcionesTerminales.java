import java.sql.Driver;

public class MenuOpcionesTerminales {


    static Object[] arrayTerminales(){
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

    public static void modificarTerminal(int input) {

        int currentPageIndexZero = DriverMenu.currentPage-1;
        input = input - 1 - currentPageIndexZero;
        input = currentPageIndexZero * 7 + input;
        System.out.println(input);
        Terminal terminalSeleccionada = Main.listaTerminales.get(input);
        Object[] premiosDeTerminalT = terminalSeleccionada.premiosEnTerminal.toArray();
        int indexDePremioSeleccionado;

        System.out.println("Que desea hacer con " + terminalSeleccionada);

        System.out.println("1 - Eliminar la terminal\n" +
                "2 - Modificar los premios de la terminal\n" +
                "0 - Back");

        switch (Main.input()) {
            case '1':
                Main.listaTerminales.remove(input);
                DriverMenu.verPagina(arrayTerminales(), 1);
            case '2':
                indexDePremioSeleccionado = (DriverMenu.seleccionDeItem(premiosDeTerminalT)) -1;
                Premio premioSeleccionado = terminalSeleccionada.premiosEnTerminal.get(indexDePremioSeleccionado);
                MenuEditarPremiosEnTerminal.menu(
                        premioSeleccionado,
                        terminalSeleccionada,
                        input,
                        indexDePremioSeleccionado
                );
            default:
                menu();
        }
    }
}
