import java.util.ArrayList;

public class Premio {

    private final String nombre;
    private final int ticketsNecesarios;
    private int stock;

    static private ArrayList<Premio> listaPremios = new ArrayList<>();
    static private final String[] nombresDePremios = {"BALON", "PELUCHE", "FUTBOLIN",
                                                    "CONSOLA", "FIGURA", "CHUCHES",
                                                    "ENTRADA", "VIDEOJUEGO", "ROPA",
                                                    "COMIDA", "MYSTERYBOX"};

    public Premio(String nombre, int ticketsNecesarios, int stock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        this.stock = stock;
    }
    public Premio(String nombre) {
        this.nombre = nombre;
        this.ticketsNecesarios = Random(200);
        this.stock = Random(20);
    }



    public String getNombre() {
        return nombre;
    }

    public int getTicketsNecesarios() {
        return ticketsNecesarios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void premiosDesdeLista() {
        for (String s : nombresDePremios) {
            listaPremios.add(new Premio(s));
        }
    }

    public static int Random(int limit) {
        return (int) (Math.random() * limit);
    }

    public static String listaPremios() {
        return listaPremios.toString();
    }
    @Override
    public String toString() {
        return nombre;
    }
}
