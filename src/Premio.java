public class Premio extends Main {

    private String nombre;
    private int ticketsNecesarios;
    private int stock;

    public Premio(String nombre, int ticketsNecesarios, int stock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        this.stock = stock;
    }

    public Premio(String nombre) {
        this.nombre = nombre;
        this.ticketsNecesarios = randomInt(200);
        this.stock = randomInt(19) + 1;
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

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setTicketsNecesarios(int precio) {
        this.ticketsNecesarios = precio;
    }

    public String info() {
        return "Nombre: " + this.getNombre() +
                ", Stock: " + this.getStock() +
                ", Precio: " + this.getTicketsNecesarios();
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
