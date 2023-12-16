
import java.util.ArrayList;

public class Main {

    public static ArrayList<Tarjeta> indiceTarjetas = new ArrayList<>();
    public static ArrayList<Integer> indiceUID = new ArrayList<>();

    public static void main(String[] args) {

        Premio[] premios = new Premio[3];
        
        Terminal t = new Terminal(premios);

        TestCases.nuevaTarjeta(99);

        t.printInfoParaUID(99);

        Premio.premiosDesdeLista();
        System.out.println(Premio.listaPremios());


    }
}
