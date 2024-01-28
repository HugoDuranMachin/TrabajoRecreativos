abstract class Main extends InformacionRecreativas {

    public static void main(String[] args) {
        mainMenu();
        System.out.println("Byebye!");
    }

     static void mainMenu() {
            System.out.println("1 - Cargar valores por defecto (Sobreescribe)\n" +
                    "2 - Modificar stock de premios\n" +
                    "3 - Modificar terminales\n" +
                    "4 - Modificar tarjetas (usuarios)\n" +
                    "5 - Iniciar Recreativas!\n" +
                    "0 - Exit");

            optionsForMenu(inputChar());
        }

    static void optionsForMenu(int input) {
        switch (input) {
            case '1':
                loadDefaults();
                break;
            case '2':
                MenuOpcionesListaPremios.menu();
                break;
            case '3':
                MenuOpcionesTerminales.menu();
                break;
            case '4':
                MenuOpcionesTarjetas.menu();
                break;
            case '5':
                resetStaticVariables();
                MenuRecreativas.menu();
                break;
            case '0':
            default:
                return;
        }
            mainMenu();
        }

}



