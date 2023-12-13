/*
Cada premio tiene un nombre, un número de tickets necesarios para conseguir ese premio y 
un recuento o stock de los elementos de esta categoría que están asignados a un terminal. 
Los premios no saben a qué terminal pertenecen.
 */

public class Premio {

    private String nombre;
    private int ticketsNecesarios;
    private int stock;

    public Premio(String nombre, int ticketsNecesarios, int stock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        this.stock = stock;
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
}
