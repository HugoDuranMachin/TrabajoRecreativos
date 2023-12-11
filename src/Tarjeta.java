
public class Tarjeta {

	private int saldoCreditos;
	private int saldoTickets;
	final private int numeroTarjeta;
	private String nombrePropietario;

	public Tarjeta(int numeroTarjeta) {

		this.numeroTarjeta = numeroTarjeta;
	}

	public Tarjeta(int numeroTarjeta, String nombrePropietario) {

		this.numeroTarjeta = numeroTarjeta;
		this.nombrePropietario = nombrePropietario;
	}

	public int getSaldoCreditos() {
		return this.saldoCreditos;
	}

	public int getSaldoTickets() {
		return this.saldoTickets;
	}

	public int getNumeroTarjeta() {
		return this.numeroTarjeta;
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
		+ "\nNúmero de Tarjeta: " + getNumeroTarjeta();
	}

	@Override
	public String toString() {
		return "Número Tarjeta: " + getNumeroTarjeta();
	}
}
