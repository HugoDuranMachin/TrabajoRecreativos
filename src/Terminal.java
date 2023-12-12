
/*
TODO: 
CREAR SISTEMA DE CANJEO DE PREMIOS
    IMPRIMIR MENSAJE ERROR SI PREMIO FUERA DE STOCK
   
LA TERMINAL SE INICIA CON UN CONSTRUCTOR QUE RECIBE 3 PREMIOS
    LOS PREMIOS VENDRÁN DE UNA ARRAYLIST DINÁMICA BASADA EN LOS TIPOS DE PREMIOS DISPONIBLES
    LA TERMINAL SÓLO PODRÁ DISPENSAR ESTE TIPO DE PREMIOS
    LA TERMINAL RECIBE EL STOCK DEL PREMIO CON EL QUE SE CONSTRUYE
 */
public class Terminal {

    public Terminal() {
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

    public void recargarTarjeta(Tarjeta t, int cantidad) {
        cantidad *= 2;
        t.setSaldoCreditos(t.getSaldoCreditos() + cantidad);
    }

    public String consultarSaldo(Tarjeta t) {
        String saldo = "Actualmente tienes " + t.getSaldoCreditos() + " créditos y " + t.getSaldoTickets() + "tickets.";
        return saldo;
    }
}
