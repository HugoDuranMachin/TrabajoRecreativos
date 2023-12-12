
import java.util.ArrayList;

public class Main {
    
    public static ArrayList<Tarjeta> indiceUsuarios = new ArrayList<>();
    public static ArrayList<Integer> numeroTarjetasParaIndice = new ArrayList<>();
    
    public static void main(String[] args) {
	
	Terminal t = new Terminal();
	
	TestCases.nuevaTarjeta(99);
	
	t.infoUsuarioDeNumero(99);
	
    }
}
