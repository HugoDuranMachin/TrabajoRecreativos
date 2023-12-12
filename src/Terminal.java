
/*
Cada terminal contiene un lector de chips de tarjetas. 
Un terminal acepta dinero que se convierte en créditos en una tarjeta. 
El dinero se acepta como números enteros. 
Los créditos se otorgan con una proporción de 2 créditos por cada euro. 
Los jugadores pueden utilizar un terminal para consultar los saldos de sus tarjetas. 
Incluya el número de la tarjeta en la impresión. 
Todos los créditos o tickets, o parte de ellos, se pueden transferir de una tarjeta a otra. 
Imprima siempre los saldos de una tarjeta cuando se acceda a los créditos o los tickets desde un terminal. 
Por último, los tickets se pueden canjear en los terminales por premios. 
Imprima un mensaje de error si una tarjeta no tiene suficientes tickets o 
si el terminal no dispone de un determinado tipo de premio. 
Imprima cuándo se concede un premio y el número restante de dicho tipo de premio en el terminal. 
Los premios se canjean siempre a través de un terminal. Un terminal ofrece hasta tres premios.
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
