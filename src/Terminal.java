import java.util.ArrayList;
import java.util.Arrays;

public class Terminal {

    ArrayList<Premio> premiosEnTerminal;

    Terminal(int entries, StockPremios sp) {

        this.premiosEnTerminal = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            premiosEnTerminal.add(premioAleatorioDeStock(sp));
        }

    }

    static Premio premioAleatorioDeStock(StockPremios sp) {
        if (sp.listaPremios.isEmpty()) {
            System.out.println("No hay premios que cargar en terminales! ERROR!");
            DriverMenu.menu();
        }
        return sp.listaPremios.get(Main.randomInt(sp.listaPremios.size()));
    }

    public void menuRecargarCreditos(Tarjeta t) {
        System.out.println("Cuanto dinero quieres meter?");
        int dineroMetido;
        try {
            dineroMetido = Integer.parseInt(Main.inputFull());
        } catch (Exception ignored) {
            System.out.println("No has metido un numero");
            menuRecargarCreditos(t);
            return;
        }

        System.out.println("Tenias " + t.getSaldoCreditos() + " creditos");
        recargarCreditos(t, dineroMetido);
        System.out.println("Has metido " + dineroMetido + " Dineros");
        System.out.println("Tienes " + t.getSaldoCreditos() + " creditos");
    }

    public boolean disponibilidadCreditos(Tarjeta t, int cantidad) {
        return !(cantidad > t.getSaldoCreditos());
    }

    public boolean disponibilidadTickets(Tarjeta t, int cantidad) {
        return !(cantidad > t.getSaldoTickets());
    }

    public void transferirTickets(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (!disponibilidadTickets(t1, cantidad)) {
            System.out.println("No tienes tickets suficientes en " + t1.getNombrePropietario());
            return;
        }
        t1.setSaldoTickets(t1.getSaldoTickets() - cantidad);
        t2.setSaldoTickets(t2.getSaldoTickets() + cantidad);
        System.out.println("Nuevo saldo para " + t1.getNombrePropietario() + ": " + t1.getSaldoTickets());
        System.out.println("Nuevo saldo para " + t2.getNombrePropietario() + ": " + t2.getSaldoTickets());

    }

    public void transferirCreditos(Tarjeta t1, Tarjeta t2, int cantidad) {
        if (!disponibilidadCreditos(t1, cantidad)) {
            System.out.println("No tienes creditos suficientes en " + t1.getNombrePropietario());
            return;
        }
        t1.setSaldoCreditos(t1.getSaldoCreditos() - cantidad);
        t2.setSaldoCreditos(t2.getSaldoCreditos() + cantidad);
        System.out.println("Nuevo saldo para " + t1.getNombrePropietario() + ": " + t1.getSaldoCreditos());
        System.out.println("Nuevo saldo para " + t2.getNombrePropietario() + ": " + t2.getSaldoCreditos());
    }

    public void recargarCreditos(Tarjeta t, int cantidad) {
        cantidad *= 2;
        t.setSaldoCreditos(t.getSaldoCreditos() + cantidad);
    }

    public void seleccionarPremioDeTerminal(Tarjeta t) {
        System.out.println("Qué premio quieres elegir?");
        Premio premioSelected = premiosEnTerminal.get(DriverMenu.seleccionDeItem(premiosEnTerminal.toArray()));
        System.out.println("Premio elegido: " + premioSelected);
        System.out.println("Precio: " + premioSelected.getTicketsNecesarios());
        System.out.println("Tickets disponibles: " + t.getSaldoTickets());
        System.out.println("1: Comprar\n" +
                "0: Exit");

        if (Main.input() == '1') {
            canjearPremio(t, premioSelected, 1);
        }
    }

    public void canjearPremio(Tarjeta t, Premio p, int cantidad) {
        System.out.println("Balance de Tickets actual: " + t.getSaldoTickets());
        int totalPrecio = p.getTicketsNecesarios()*cantidad;
        if (disponibilidadTickets(t, totalPrecio)) {
            System.out.println("No tienes los tickets necesarios");
            return;
        }

        if (p.getStock() <= 0) {
            System.out.println("No queda stock!");
            return;
        }

        t.setSaldoTickets(t.getSaldoTickets() - totalPrecio);
        t.addPremio(p);
        p.setStock(p.getStock() - cantidad);
        System.out.println("Premio obtenido: " + p);
        System.out.println("Nuevo balance: " + t.getSaldoTickets());
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
