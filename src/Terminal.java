
public class Terminal {

    String[] premios = new String[3];

    public Terminal() {
    }

    public Terminal(String premios[]) {
        this.premios = premios;
    }

    public void infoUsuarioDeNumero(int numeroTarjeta) {
        System.out.println(Main.indiceUsuarios.get(Main.numeroTarjetasParaIndice.indexOf(numeroTarjeta)).info());
    }

    public void transferirTickets(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (cantidad > t1.getSaldoCreditos()) {
            System.out.println("No dispone de tickets suficientes");
        } else {
            t1.setSaldoTickets(t1.getSaldoTickets() - cantidad);
            t2.setSaldoTickets(t2.getSaldoTickets() + cantidad);
        }
    }

    public void transferirCreditos(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (cantidad > t1.getSaldoCreditos()) {
            System.out.println("No dispone de créditos suficientes");
        } else {
            t1.setSaldoCreditos(t1.getSaldoCreditos() - cantidad);
            t2.setSaldoCreditos(t2.getSaldoCreditos() + cantidad);
        }
    }

    public void recargarCreditos(Tarjeta t, int cantidad) {
        cantidad *= 2;
        t.setSaldoCreditos(t.getSaldoCreditos() + cantidad);
    }

    public String consultarSaldo(Tarjeta t) {
        String saldo = "Actualmente tienes " + t.getSaldoCreditos() + " créditos y " + t.getSaldoTickets() + "tickets.";
        return saldo;
    }

    public void canjearPremios(Tarjeta t, Premio p, int cantidad) {
        if (t.getSaldoTickets() < (p.getTicketsNecesarios() * cantidad) || cantidad > p.getStock()) {
            System.out.println("Error");
        } else {
            t.setSaldoTickets(t.getSaldoTickets() - (p.getTicketsNecesarios() * cantidad));
            p.setStock(p.getStock() - cantidad);
            System.out.println("Quedan " + p.getStock() + " premios");
        }
    }
}
