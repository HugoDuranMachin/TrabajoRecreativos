public class MenuRecreativas  extends DriverMenu {


    static void menu() {

        String terminal = (selectedTerminal == null) ? "No hay terminal seleccionada" : selectedTerminal.toString();
        System.out.println("1 - Elegir Tarjeta con la que jugar\n" +
                "2 - Jugar a un juego\n" +
                "3 - Interactuar con la terminal seleccionada\n" +
                "4 - Cambiar la terminal actual (" + terminal + ")\n" +
                "0 - Exit");

        optionsForMenu(input());
    }

    static void optionsForMenu(int selection) {
        switch (selection) {
            case '1':
                selectedPlayer = selectPlayer();
                menu();
                break;
            case '2':
                if (selectedPlayer == null) {
                    System.out.println("Por favor elige una tarjeta!");
                    menu();
                }
                playGame();
                break;
            case '3':
                if (selectedTerminal == null) {
                    System.out.println("No hay una terminal seleccionada, por favor elige una terminal");
                    selectTerminal();
                }
                menuTerminal(selectedTerminal);
                break;
            case '4':
                selectTerminal();
                menuTerminal(selectedTerminal);
            default:
                DriverMenu.menu();
        }

    }

    public static Tarjeta selectPlayer() {
        System.out.println("Elige una tarjeta: ");
        selectPlayerSaveVariables();
        System.out.println("Has seleccionado: " + selectedPlayer.getNombrePropietario());
        return selectedPlayer;
    }

    public static void playGame() {
        Juego j = new Juego("Cambio De Divisa", Main.randomInt(100));
        System.out.println("No han habido fuerzas de crear juegos!\n" +
                "A cambio, mete créditos y recibe monedas!\n" +
                "Este juego cuesta: " + j.getCreditosNecesarios() + " creditos\n" +
                "Tienes: " + selectedPlayer.getSaldoCreditos() + " creditos\n" +
                "¿Quieres Jugar?\n" + "1: ¡Sí!\n" + "0: Exit");

        if (Main.input() == '1') {//Codigo de Hugo
            System.out.println(j.jugar(selectedPlayer, j));
        }
        menu();
    }

    public static void selectTerminal() {
        System.out.println("Elige una terminal: ");
        selectedTerminal = listaTerminales.get(seleccionDeItem(arrayTerminales()));
        System.out.println("Has seleccionado la terminal: " + selectedTerminal);
    }

    public static void menuTerminal(Terminal t) {
        System.out.println("Esta terminal tiene los siguientes premios: ");
        System.out.println(t.premiosEnTerminal);

        System.out.println("1 - Seleccionar un premio\n" +
                "2 - Ver información de mi tarjeta\n" +
                "3 - Recargar Creditos\n" +
                "4 - Intercambiar Tickets con otra tarjeta\n" +
                "5 - Intercambiar Creditos con otra tarjeta\n" +
                "0 - Exit");

        optionsForTerminal(t, Main.input());
    }

    public static void optionsForTerminal(Terminal t, int selection) {
        switch (selection) {
            case '1':
                selectedTerminal.seleccionarPremioDeTerminal(selectedPlayer);
                break;
            case '2':
                System.out.println(selectedPlayer.info());
                break;
            case '3':
                selectedTerminal.menuRecargarCreditos(selectedPlayer);
                break;
            case '4':
                selectedTerminal.transferirTickets(selectedPlayer, targetUser(), inputInt());
                break;
            case '5':
                selectedTerminal.transferirCreditos(selectedPlayer, targetUser(), inputInt());
                break;
            default:
                menu();
                break;
        }
        menuTerminal(t);
    }

    public static Tarjeta targetUser() {
        System.out.println("Elige una segunda tarjeta recipiente: ");
        Tarjeta t2 = selectPlayer();
        if (t2 == selectedPlayer) {
            System.out.println("Silly, that's you!");
            menuTerminal(selectedTerminal);
        }
        return t2;
    }

    public static int inputInt() {
        System.out.println("Dame una cantidad: ");
        try {
            return Integer.parseInt(Main.inputFull());
        } catch (Exception ignored) {
            System.out.println("No has metido un numero");
            menuTerminal(selectedTerminal);
        }
        return 0;
    }
}


