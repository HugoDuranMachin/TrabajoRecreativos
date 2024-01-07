
/**
 *@author RM
 */
public class myMethods {

    public static int randomInt(int limit) {
        return (int) (Math.random() * limit);
    }


    public static void nuevaTarjeta() {
        Tarjeta t = new Tarjeta(Main.indiceTarjetas.size());
        Main.indiceTarjetas.add(t);
        Main.indiceUID.add(Main.indiceTarjetas.size());
    }

    public static void nuevaTarjeta(int UID) {
        Tarjeta t = new Tarjeta(UID);
        Main.indiceTarjetas.add(t);
        Main.indiceUID.add(UID);
    }

    public static void quitarTarjeta(int index) {
        //Main.listaUsuarios.remove(index);
        //Main.keymap.add()
    }

    public static void transferenciaDinero() {
        nuevaTarjeta(999);
        nuevaTarjeta(1000);

    }

}
