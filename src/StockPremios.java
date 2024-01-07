import java.util.ArrayList;

public class StockPremios {

    //Constructor, crea la lista en memoria sobre la que se tiene que operar
    StockPremios() {
    }
    //truco del almendruco para sobreescribir mas tarde
    StockPremios(int i) {
        premiosDesdeLista();
    }

    static private final String[] listaNombres = {
            "BALON", "PELUCHE", "FUTBOLIN",
            "CONSOLA", "FIGURA", "CHUCHES",
            "ENTRADA", "VIDEOJUEGO", "ROPA",
            "COMIDA", "MYSTERYBOX"};

    public ArrayList<Premio> listaPremios = new ArrayList<>();

    public void premiosDesdeLista() {
        for (String s : listaNombres) {
            this.listaPremios.add(new Premio(s));
        }
    }

    public void addPremio(String s) {
        this.listaPremios.add(new Premio(s));
    }

}
