public class Tarjeta {
    private int saldoCreditos;
    private int saldoTickets;
    private int numeroTarjeta;
    
    public Tarjeta(int saldoCreditos, int saldoTickets) {
        this.saldoCreditos = saldoCreditos;
        this.saldoTickets = saldoTickets;
        this.numeroTarjeta = (int) Math.random()*1000000000;
    }

    public int getSaldoCreditos() {
        return saldoCreditos;
    }

    public int getSaldoTickets() {
        return saldoTickets;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setSaldoCreditos(int saldoCreditos) {
        this.saldoCreditos = saldoCreditos;
    }

    public void setSaldoTickets(int saldoTickets) {
        this.saldoTickets = saldoTickets;
    }
}
