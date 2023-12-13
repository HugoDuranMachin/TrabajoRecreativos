
import java.util.ArrayList;

public class Main {

    public static ArrayList<Tarjeta> indiceTarjetas = new ArrayList<>();
    public static ArrayList<Integer> indiceUID = new ArrayList<>();

    public static void main(String[] args) {

        Terminal t = new Terminal();

        TestCases.nuevaTarjeta(99);

        t.printInfoParaUID(99);

    }
}
