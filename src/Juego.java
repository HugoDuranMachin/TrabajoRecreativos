public class Juego {
    private final int creditosNecesarios;
    
    public Juego(String nombre, int creditosNecesarios) {
        this.creditosNecesarios = creditosNecesarios;
    }

    public int getCreditosNecesarios() {
        return creditosNecesarios;
    }
    
    public String jugar(Tarjeta t, Juego j) {
        String respuesta = "No dispone de créditos suficientes";
        int tickets = Main.randomInt(1000);
        if(t.getSaldoCreditos()>j.getCreditosNecesarios()) {
            t.setSaldoCreditos(t.getSaldoCreditos()-j.getCreditosNecesarios());
            t.setSaldoTickets(tickets + t.getSaldoTickets());
            respuesta = "Numero tarjeta: " + t.getUID() + "\nTickets ganados: " + tickets + "\nTickets totales: " + t.getSaldoTickets();
        }
        return respuesta;
    }
}
