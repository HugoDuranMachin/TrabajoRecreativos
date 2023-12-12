
/**
 *@author RM
 */
public class TestCases {

    public static void nuevaTarjeta() {
	Tarjeta t = new Tarjeta(Main.indiceUsuarios.size());
	Main.indiceUsuarios.add(t);
	Main.numeroTarjetasParaIndice.add(Main.indiceUsuarios.size());
    }
    
     public static void nuevaTarjeta(int numeroTarjeta) {
	Tarjeta t = new Tarjeta(numeroTarjeta);
	Main.indiceUsuarios.add(t);
	Main.numeroTarjetasParaIndice.add(numeroTarjeta);
    }
    
    public static void quitarTarjeta(int index) {
	//Main.listaUsuarios.remove(index);
	//Main.keymap.add()
    }
    
    public static void transferenciaDinero(){
	nuevaTarjeta(999);
	nuevaTarjeta(1000);
	
    }

}
