public class Premio {

    private final String nombre;
    private final int ticketsNecesarios;
    private int stock;

    public Premio(String nombre, int ticketsNecesarios, int stock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        this.stock = stock;
    }

    public Premio(String nombre) {
        this.nombre = nombre;
        this.ticketsNecesarios = myMethods.randomInt(200);
        this.stock = myMethods.randomInt(19) + 1;
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

    @Override
    public String toString() {
        return "Premio: " + this.getNombre() +
                " - Stock: " + this.getStock() +
                " - Precio: " + this.getTicketsNecesarios();
    }
}
