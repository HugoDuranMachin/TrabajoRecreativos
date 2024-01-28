abstract class SeleccionYPaginacion extends InformacionRecreativas {

    static int currentPage = 1;
    static int lastPage = 1;
    static int returnValue = 0;
    // I need to come out of here with this ((input - 49) + ((currentPage - 1) * 7));

    public static int getItemFromPageInArray(Object[] obj) throws Exception {
        lastPage = (obj.length / 7) + 1;
        displayItemsFromPageInArray(obj);
        char buffer = inputChar();
        if (buffer == '0') {
            throw new Exception();
        }
        actionForItemInPage(obj, buffer);
        return returnValue;
    }

    static void actionForItemInPage(Object[] obj, char input) {
        switch (input) {
            case '1': case '2': case '3': case '4': case '5': case '6': case '7':
                returnValue = ((input - 49) + ((currentPage - 1) * 7));
                return;
            case '0':
            default:
                currentPage = 1;
                return;
            case '8':
                currentPage = currentPage - 1;
                break;
            case '9':
                currentPage = currentPage + 1;
                break;
        }
        if (!isLastOrFirstPage(currentPage)) {
            displayItemsFromPageInArray(obj);
        }
        actionForItemInPage(obj, inputChar());
    }


    static boolean isLastOrFirstPage(int page) {
        if (page <= 0) {
            System.out.println("No hay página anterior");
            currentPage++;
            return true;
        }

        if (page > lastPage) {
            System.out.println("No hay página siguiente");
            currentPage--;
            return true;
        }
        return false;
    }

     static void displayItemsFromPageInArray(Object[] obj) {
        boolean isLastPage = (currentPage == lastPage);
            /*
            This function is written in a way that allows you to input any number page n
            and visualize it, even if that functionality goes currently unused
             */
        int iteratedItemInPage = (currentPage - 1) * 7;
        int lastItemInPage = iteratedItemInPage + (isLastPage ? obj.length % 7 : 7);

        System.out.println("Pagina: " + currentPage + " de " + lastPage);

        for (int i = 0; iteratedItemInPage < lastItemInPage; i++) {
            System.out.println((i + 1) + ": " + obj[iteratedItemInPage]);
            iteratedItemInPage++;
        }

        System.out.println("8: Pagina Atras\n" +
                "9: Pagina Siguiente\n" +
                "0: Exit Menu");
    }

    static void selectPremioSaveVariables() {
        try {
            indexPremioSelected = getItemFromPageInArray(arrayPremios());
            selectedPremio = stockPremios.listaPremios.get(indexPremioSelected);
        } catch (Exception ignored) {
        }
    }

    static void selectPremioFromTerminalSaveVariables(Terminal t) {
        try {
            indexPremioSelected = getItemFromPageInArray(arrayPremiosEnTerminal(t));
            selectedPremio = t.premiosEnTerminal.get(indexPremioSelected);
        } catch (Exception ignore) {
        }
    }

    static void selectTerminalSaveVariables() {
        try {
            indexTerminalSelected = getItemFromPageInArray(arrayTerminales());
            selectedTerminal = listaTerminales.get(indexTerminalSelected);
        } catch (Exception ignored) {
        }
    }

    static void selectPlayerSaveVariables() {
        try {
            indexPlayerSelected = getItemFromPageInArray(arrayTarjetas());
            selectedPlayer = mapaTarjetas.get(indexPlayerSelected);
        } catch (Exception ignored) {
        }
    }
}


