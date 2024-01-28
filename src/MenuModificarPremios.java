class MenuModificarPremios extends MenuOpcionesListaPremios {

     public static void menu() {

        System.out.println("Que desea hacer con " + selectedPremio + "? (Se aplica a todas las instancias de este premio)");

        System.out.println("1 - Eliminar el premio (ROMPE TODAS LAS TERMINALES INICIALIZADAS)\n" +
                "2 - Ver informacion sobre el premio\n" +
                "3 - Modificar el nombre del premio\n" +
                "4 - Modificar los tickets necesarios para canjear\n" +
                "5 - Modificar su stock\n" +
                "0 - Back");

        switchForMenuModificarPremio(inputChar());
    }

    static void switchForMenuModificarPremio(char selection) {

        switch (selection) {
            case '1':
                stockPremios.listaPremios.remove(indexPremioSelected);
                return;
            case '2':
                System.out.println(selectedPremio.info());
                break;
            case '3':
                selectedPremio.setNombre(nuevoNombreParaPremio());
                break;
            case '4':
                selectedPremio.setTicketsNecesarios(nuevoPrecioParaPremio());
                break;
            case '5':
                selectedPremio.setStock(nuevoStockParaPremio());
                break;
            default:
                return;
        }
        menu();

    }
}
