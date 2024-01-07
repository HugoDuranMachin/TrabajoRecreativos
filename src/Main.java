import java.util.ArrayList;

/*
TODO:
Initialize terminals with 3 random prizes
make sure those prizes can be claimed and
that when there's overlapping prizes in different terminals
prizes still react accordingly
make test cases for emptying the prizes
 */

public class Main {

    public static ArrayList<Tarjeta> indiceTarjetas = new ArrayList<>();
    public static ArrayList<Integer> indiceUID = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        myMethods.nuevaTarjeta(99);


        //Personal, WIP
        Map testingMap = new Map(4,4);
        Map.printMap(testingMap.getMap());

        MainMenu.firstMenu();

    }

}


