

public class Terminal {

    Premio[] premiosEnTerminal = new Premio[3];

    public Terminal(Premio P[]) {
        this.premiosEnTerminal = P;
    }

    public void printInfoParaUID(int UID) {
        System.out.println(Main.indiceTarjetas.get(Main.indiceUID.indexOf(UID)).info());
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
        String saldo = t.info();
        return saldo;
    }

    public String canjearPremios(Tarjeta t, Premio p, int cantidad) {
        String respuesta = "Error";
        if (t.getSaldoTickets() >= (p.getTicketsNecesarios() * cantidad) || cantidad >= p.getStock()) {            t.setSaldoTickets(t.getSaldoTickets() - (p.getTicketsNecesarios() * cantidad));
            p.setStock(p.getStock() - cantidad);
            respuesta = "Operación correcta.\nQuedan " + p.getStock() + " premios";
        }
        return respuesta;
    }
}
