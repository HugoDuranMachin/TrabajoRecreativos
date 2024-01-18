
public class Tarjeta {

    private int saldoCreditos;
    private int saldoTickets;
    private String nombrePropietario;
    private final int uniqueID;

    Tarjeta(int UID) {
        this.uniqueID = UID;
    }

    Tarjeta(int UID, String nombrePropietario) {

        this.uniqueID = UID;
        this.nombrePropietario = nombrePropietario;
    }

    public int getSaldoCreditos() {
        return this.saldoCreditos;
    }

    public int getSaldoTickets() {
        return this.saldoTickets;
    }

    public int getUID() {
        return this.uniqueID;
    }

    public String getNombrePropietario() {
        return this.nombrePropietario;
    }

    public void setSaldoCreditos(int saldoCreditos) {
        this.saldoCreditos = saldoCreditos;
    }

    public void setSaldoTickets(int saldoTickets) {
        this.saldoTickets = saldoTickets;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String info() {
        return "Saldo Tickets: " + getSaldoTickets()
                + "\nSaldo Créditos: " + getSaldoCreditos()
                + "\nNúmero de Tarjeta: " + getUID();
    }

    @Override
    public String toString() {
        return "UID: " + getUID() + " Nombre: " + getNombrePropietario();
    }
}
