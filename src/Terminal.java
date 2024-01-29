import java.util.ArrayList;
import java.util.Arrays;

public class Terminal extends Main {

    ArrayList<Premio> premiosEnTerminal;

    Terminal(int entries, StockPremios stockPremios) {

        this.premiosEnTerminal = new ArrayList<>();
        for (int i = 0; i < entries; i++) {
            premiosEnTerminal.add(premioAleatorioDeStock(stockPremios));
        }
    }

    static Premio premioAleatorioDeStock(StockPremios stockPremios) {
        return stockPremios.listaPremios.get(randomInt(stockPremios.listaPremios.size()));
    }

    public static void menuRecargarCreditos(Tarjeta t) {
        System.out.println("Cuanto dinero quieres meter?");
        int dineroMetido = inputInt();
        System.out.println(dineroMetido);
        System.out.println("Tenias " + t.getSaldoCreditos() + " creditos");
        recargarCreditos(t, dineroMetido);
        System.out.println("Has metido " + dineroMetido + " Dineros");
        System.out.println("Tienes " + t.getSaldoCreditos() + " creditos");
    }

    static boolean doesPlayerHaveEnoughCredits(Tarjeta t, int cantidad) {
        return (t.getSaldoCreditos() > cantidad);
    }

    static boolean doesPlayerHaveEnoughTickets(Tarjeta t, int cantidad) {
        return (t.getSaldoTickets() > cantidad);
    }

    public static void transferirTickets(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (!doesPlayerHaveEnoughTickets(t1, cantidad)) {
            System.out.println("No tienes tickets suficientes en " + t1.getNombrePropietario());
            return;
        }
        t1.setSaldoTickets(t1.getSaldoTickets() - cantidad);
        t2.setSaldoTickets(t2.getSaldoTickets() + cantidad);
        System.out.println("Nuevo saldo para " + t1.getNombrePropietario() + ": " + t1.getSaldoTickets());
        System.out.println("Nuevo saldo para " + t2.getNombrePropietario() + ": " + t2.getSaldoTickets());

    }

    public static void transferirCreditos(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (!doesPlayerHaveEnoughCredits(t1, cantidad)) {
            System.out.println("No tienes creditos suficientes en " + t1.getNombrePropietario());
            return;
        }
        t1.setSaldoCreditos(t1.getSaldoCreditos() - cantidad);
        t2.setSaldoCreditos(t2.getSaldoCreditos() + cantidad);
        System.out.println("Nuevo saldo para " + t1.getNombrePropietario() + ": " + t1.getSaldoCreditos());
        System.out.println("Nuevo saldo para " + t2.getNombrePropietario() + ": " + t2.getSaldoCreditos());
    }

    public static void recargarCreditos(Tarjeta t, int cantidad) {
        cantidad *= 2;
        t.setSaldoCreditos(t.getSaldoCreditos() + cantidad);
    }
    

    public static void canjearPremio(Tarjeta tarjeta, Premio p, int cantidad) {
        System.out.println("Balance de Tickets actual: " + tarjeta.getSaldoTickets());
        int totalPrecio = p.getTicketsNecesarios()*cantidad;
        if (!doesPlayerHaveEnoughTickets(tarjeta, totalPrecio)) {
            System.out.println("No tienes los tickets necesarios");
            return;
        }

        if (p.getStock() <= 0) {
            System.out.println("No queda stock!");
            return;
        }

        tarjeta.setSaldoTickets(tarjeta.getSaldoTickets() - totalPrecio);
        tarjeta.addPremio(p);
        p.setStock(p.getStock() - cantidad);
        System.out.println("Premio obtenido: " + p);
        System.out.println("Nuevo balance: " + tarjeta.getSaldoTickets());
    }

    /*
    BLOQUE DE MANIPULACION DE TARJETAS
     */
    public static void printInfoParaUID(int UID) {
        System.out.println(mapaTarjetas.get(UID));
    }

    public static void nuevaTarjeta() {
        mapaTarjetas.put(UID, new Tarjeta(UID));
        UID++;
    }

    public static void nuevaTarjeta(String nombre, int creditos) {
        mapaTarjetas.put(UID, new Tarjeta(UID, nombre, creditos));
        UID++;
    }

    //TODO: THIS DOESN'T CHECK IF IT EXISTS!
    public static void quitarTarjeta(int UID) {
        mapaTarjetas.remove(UID);
    }

    //TODO: this function, I'm tired.
    public static void quitarTarjeta(Tarjeta t) {
    }

    @Override
    public String toString() {
        return "Premios: " + Arrays.toString(new ArrayList[]{this.premiosEnTerminal});
    }
}
