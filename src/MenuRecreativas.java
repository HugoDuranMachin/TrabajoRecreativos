public class MenuRecreativas extends SeleccionYPaginacion {

    static void menu() {

        String terminal = (selectedTerminal == null) ? "No hay terminal seleccionada" : selectedTerminal.toString();
        System.out.println("1 - Elegir Tarjeta con la que jugar\n" +
                "2 - Jugar a un juego\n" +
                "3 - Interactuar con la terminal seleccionada\n" +
                "4 - Cambiar la terminal actual (" + terminal + ")\n" +
                "0 - Exit");

        optionsForMenu(inputChar());
    }

    static void optionsForMenu(char selection) {
        switch (selection) {
            case '1':
                selectPlayer();
                break;
            case '2':
                if (!isAPlayerSelected()) {
                    System.out.println("Por favor elige una tarjeta!");
                    break;
                }
                playGame();
                break;
            case '3':
                if (!isATerminalSelected()) {
                    System.out.println("No hay una terminal seleccionada, por favor elige una terminal");
                    break;
                }
                menuParaTerminal();
                break;
            case '4':
                System.out.println("Elige una terminal: ");
                selectTerminalSaveVariables();
                if (!isATerminalSelected()) {
                    System.out.println("Terminal no valida");
                    break;
                }
                break;
            default:
                return;
            }
            menu();
    }

    public static void selectPlayer() {
        System.out.println("Elige una tarjeta: ");
        selectPlayerSaveVariables();
        if (!isAPlayerSelected()) {
            System.out.println("Targeta no valida");
            return;
        }
        System.out.println("Has seleccionado: " + selectedPlayer.getNombrePropietario());
    }

    public static void playGame() {
        //TODO: more than the bare minimum!
        Juego j = new Juego("Cambio De Divisa", Main.randomInt(100));
        System.out.println("No han habido fuerzas de crear juegos!\n" +
                "A cambio, mete créditos y recibe monedas!\n" +
                "Este juego cuesta: " + j.getCreditosNecesarios() + " creditos\n" +
                "Tienes: " + selectedPlayer.getSaldoCreditos() + " creditos\n" +
                "¿Quieres Jugar?\n" + "1: ¡Sí!\n" + "0: Exit");

        if (Main.inputChar() == '1') {//Codigo de Hugo
            System.out.println(j.jugar(selectedPlayer, j));
        }
    }


    //TODO: Move to another file?
    public static void menuParaTerminal() {
        System.out.println("Esta terminal tiene los siguientes premios: ");
        System.out.println(selectedTerminal.premiosEnTerminal);

        System.out.println("1 - Seleccionar un premio\n" +
                "2 - Ver información de mi tarjeta\n" +
                "3 - Recargar Creditos\n" +
                "4 - Intercambiar Tickets con otra tarjeta\n" +
                "5 - Intercambiar Creditos con otra tarjeta\n" +
                "0 - Exit");

        optionsForTerminal(inputChar());
    }

    public static void optionsForTerminal(int selection) {
        int amount;
        if (selectedPlayer == null) {
            System.out.println("No hay un jugador seleccionado, por favor elige una tarjeta");
            return;
        }
        switch (selection) {
            case '1':
                seleccionarPremioDeTerminal(selectedPlayer);
                break;
            case '2':
                System.out.println(selectedPlayer.info());
                break;
            case '3':
                Terminal.menuRecargarCreditos(selectedPlayer);
                break;
            case '4':
                try {
                    askAndTransferBetweenUsers();
                    System.out.println("Di cuantos tickets a transferir");
                    amount = inputInt();
                } catch (Exception ignored) {
                    System.out.println("Algo ha ido mal");
                    break;
                }
                Terminal.transferirTickets(selectedPlayer, targetPlayer, amount);
                break;
            case '5':
                try {
                    askAndTransferBetweenUsers();
                    System.out.println("Di cuantos creditos a transferir");
                    amount = inputInt();
                    Terminal.transferirCreditos(selectedPlayer, targetPlayer, amount);
                } catch (Exception ignored) {}
                break;
            default:
                return;
        }
        menuParaTerminal(); //(This is right, stop changing it)
    }

    static void askAndTransferBetweenUsers() throws Exception {
        System.out.println("¿Quien sera el recipiente?");
        selectTargetPlayer();
        if (isSourceAndTargetSame() | targetPlayer == null) {
            System.out.println("Eleccion invalida");
            throw new Exception();
        }
    }

    //This is scuff and I'll probably rewrite it?
    static void selectTargetPlayer() {
        targetPlayer = selectedPlayer;
        int buffer = indexPlayerSelected;
        selectPlayer(); //Overwrites selectedPlayer and indexPlayerSelected
        selectedPlayer = targetPlayer; //selectedPlayer is the first player selected now
        targetPlayer = mapaTarjetas.get(indexPlayerSelected); //targetPlayer is the second
        indexPlayerSelected = buffer; //I couldn't make this fancier
    }



    static void seleccionarPremioDeTerminal(Tarjeta t) {
        System.out.println("Qué premio quieres elegir?");
        selectPremioFromTerminalSaveVariables(selectedTerminal);
        System.out.println("Premio elegido: " + selectedPremio);
        System.out.println("Precio: " + selectedPremio.getTicketsNecesarios());
        System.out.println("Tickets disponibles: " + t.getSaldoTickets());
        System.out.println("1: Comprar\n" +
                "0: Exit");

        if (inputChar() == '1') {
            Terminal.canjearPremio(t, selectedPremio, 1);
        }
    }
}


