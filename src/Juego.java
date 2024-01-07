/* 
Cada juego tiene un nombre único en toda la sala. 
Los juegos requieren un determinado número de créditos para poder jugar. 
Cada juego está equipado con un lector de tarjetas y una pequeña pantalla informativa. 
Al leer una tarjeta, se reduce su saldo de créditos según el coste del juego y 
genera un número no negativo aleatorio de tickets. 
Se imprime el número de tarjeta, el número de tickets ganados al jugar, junto con el nuevo total de tickets. 
Se imprime un mensaje si una tarjeta no tiene suficientes créditos para jugar.
*/
public class Juego {
    private String nombre;
    private int creditosNecesarios;
    
    public Juego(String nombre, int creditosNecesarios) {
        this.nombre = nombre;
        this.creditosNecesarios = creditosNecesarios;
    }

    public int getCreditosNecesarios() {
        return creditosNecesarios;
    }
    
    public String jugar(Tarjeta t, Juego j) {
        String respuesta = "No dispone de créditos suficientes";
        int tickets = myMethods.randomInt(1000);
        if(t.getSaldoCreditos()>j.getCreditosNecesarios()) {
            t.setSaldoCreditos(t.getSaldoCreditos()-j.getCreditosNecesarios());
            t.setSaldoTickets(tickets);
            respuesta = "Numero tarjeta: " + t.getUID() + "\nTickets ganados: " + tickets + "\nTickets totales: " + t.getSaldoTickets();
        }
        return respuesta;
    }
}
