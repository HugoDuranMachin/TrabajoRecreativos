import java.util.ArrayList;
import java.util.Arrays;

public class Terminal {

    ArrayList<Premio> premiosEnTerminal;

    Terminal(int entries, StockPremios sp) {

        this.premiosEnTerminal = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            premiosEnTerminal.add(premioAleatorioDeStock(sp));
        }
        ;

    }

    static Premio premioAleatorioDeStock(StockPremios sp) {
        if (sp.listaPremios.isEmpty()) {
            System.out.println("No hay premios que cargar en terminales! ERROR!");
            DriverMenu.menu();
        }
        return sp.listaPremios.get(Main.randomInt(sp.listaPremios.size()));
    }

    public void getPremiosDeTerm() {
        for (Premio p : premiosEnTerminal) {
            System.out.println(p);
        }
    }

    public void canjearPremio(int index) {

        premiosEnTerminal.get(index).setStock(premiosEnTerminal.get(index).getStock() - 1);
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
        return t.info();
    }

    public String canjearPremios(Tarjeta t, Premio p, int cantidad) {
        String respuesta = "Error";
        if (t.getSaldoTickets() >= (p.getTicketsNecesarios() * cantidad) || cantidad >= p.getStock()) {
            t.setSaldoTickets(t.getSaldoTickets() - (p.getTicketsNecesarios() * cantidad));
            p.setStock(p.getStock() - cantidad);
            respuesta = "Operación correcta.\nQuedan " + p.getStock() + " premios";
        }
        return respuesta;
    }

    /*
    BLOQUE DE MANIPULACION DE TARJETAS
     */
    public static void printInfoParaUID(int UID) {
        System.out.println(Main.mapaTarjetas.get(UID));
    }

    public static void nuevaTarjeta() {
        Main.mapaTarjetas.put(Main.UID, new Tarjeta(Main.UID));
        Main.UID++;
    }

    public static void nuevaTarjeta(String nombre, int creditos) {
        Main.mapaTarjetas.put(Main.UID, new Tarjeta(Main.UID, nombre, creditos));
        Main.UID++;
    }

    //TODO: THIS DOESN'T CHECK IF IT EXISTS!
    public static void quitarTarjeta(int UID) {
        Main.mapaTarjetas.remove(UID);
    }

    @Override
    public String toString() {
        return "Premios: " + Arrays.toString(new ArrayList[]{this.premiosEnTerminal});
    }
}
