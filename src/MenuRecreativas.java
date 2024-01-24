public class MenuRecreativas {

    /*
TODO:
    Cargar creditos en cada tarjeta (Crear una opcion en el menu driver que cargue creditos)
    Jugar a "varios juegos"
    Transferir Creditos y Tickets
    Intentar jugar y solicitar un premio con la tarjeta 1
*/
    static Tarjeta selectedPlayer;
    static Terminal selectedTerminal;
    public static void menu() {

        /*
        TODO:
            al iniciar, elegir una tarjeta con la que jugar
            submenu:
                jugar con la tarjeta
                canjear un premio con la tarjeta
                intercambiar creditos y tickets con la tarjeta
                guardar el premio recibido en la tarjeta
         */

        System.out.println("1 - Elegir Tarjeta con la que jugar\n" +
                    "2 - Jugar a un juego\n" +
                    "3 - Interactuar con una terminal\n" +
                    "0 - Exit");

        optionsForMenu(Main.input());
    }

    public static void optionsForMenu(int selection) {
        switch (selection) {
            case '1':
                selectPlayer();
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
                    selectTerminal();
                    menu();
                }
                menuTerminal(selectedTerminal);
            default:
                DriverMenu.menu();
        }

    }

    public static void selectPlayer() {
        System.out.println("Elige una tarjeta: ");
        selectedPlayer = Main.mapaTarjetas.get(DriverMenu.seleccionDeItem(MenuOpcionesTarjetas.arrayTarjetas()));
        System.out.println("Estás jugando como: " + selectedPlayer.getNombrePropietario());
        menu();
    }

    public static void playGame() {
        Juego j = new Juego("Cambio De Divisa", Main.randomInt(100));
        System.out.println("No han habido fuerzas de crear juegos!\n"+
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
        selectedTerminal = Main.listaTerminales.get(DriverMenu.seleccionDeItem(MenuOpcionesTerminales.arrayTerminales()));
        System.out.println("Has seleccionado la terminal: " + selectedTerminal);
        menu();
    }

    public static void menuTerminal(Terminal t) {
        System.out.println("Esta terminal tiene los siguientes premios: ");
        System.out.println(t.premiosEnTerminal);

        System.out.println("1 - Seleccionar un premio\n" +
                "2 - Ver información de mi tarjeta\n" +
                "3 - Intercambiar Tickets con otra tarjeta\n" +
                "4 - Intercambiar Creditos con otra tarjeta\n" +
                "0 - Exit");

        optionsForTerminal(t, Main.input());
    }

    public static void optionsForTerminal(Terminal t, int selection) {
        switch (selection) {
            case '1':
                seleccionarPremioDeTerminal(t);
                break;
            case '2':
                System.out.println(selectedPlayer.info());
                break;
            case '3':
                //menuIntercambiarTickets();
                break;
            case '4':
                //menuIntercambiarCreditos();
                break;
            default:
                break;
        }
        menu();
    }

    public static void seleccionarPremioDeTerminal(Terminal t) {
        System.out.println("Qué premio quieres elegir?");
        Premio premioSelected = t.premiosEnTerminal.get(DriverMenu.seleccionDeItem(t.premiosEnTerminal.toArray()));
        System.out.println("Premio elegido: " + premioSelected);
        System.out.println("Precio: " + premioSelected.getTicketsNecesarios());
        System.out.println("Tickets disponibles: " + selectedPlayer.getSaldoTickets());
        System.out.println("1: Comprar\n" +
                "0: Exit");

        if (Main.input() == '1') {
            confirmarCompra(premioSelected);
        };

        menu();

    }

    public static void confirmarCompra(Premio p) {

        if (p.getTicketsNecesarios() > selectedPlayer.getSaldoTickets()) {
            System.out.println("No tienes los tickets necesarios");
            return;
        }



    }}
