
import java.util.ArrayList;

public class Main {
    
    public static ArrayList<Tarjeta> indiceUsuarios = new ArrayList<>();
    public static ArrayList<Integer> numeroTarjetasParaIndice = new ArrayList<>();
    
    
    public static void infoUsuarioDeNumero(int numeroTarjeta){
	System.out.println(indiceUsuarios.get(numeroTarjetasParaIndice.indexOf(numeroTarjeta)).info());
    }
    
    public static void main(String[] args) {
	
	
	TestCases.nuevaTarjeta(99);
	infoUsuarioDeNumero(99);
	
    }
}
