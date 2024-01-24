import java.util.ArrayList;

public class Tarjeta {

    private int saldoCreditos = 0;
    private int saldoTickets = 0;
    private String nombrePropietario = "Empty";
    private final int uniqueID;
    private ArrayList<Premio> premiosObtenidos = new ArrayList<>();

    Tarjeta(int UID) {
        this.uniqueID = UID;
    }

    Tarjeta(int UID, String nombre, int creditos) {
        this.uniqueID = UID;
        this.nombrePropietario = nombre;
        this.saldoCreditos = creditos;
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

    public void addPremio(Premio p) {
        //lazy
        this.premiosObtenidos.add(p);
    }

    //Ideally this should be in the terminal, but I'm tired
    public String info() {
        return "Saldo Tickets: " + getSaldoTickets()
                + "\nSaldo Créditos: " + getSaldoCreditos()
                + "\nNúmero de Tarjeta: " + getUID()
                + "\nPremios obtenidos: " + premiosObtenidos;
    }

    @Override
    public String toString() {
        return "UID: " + getUID() + " Nombre: " + getNombrePropietario();
    }
}
