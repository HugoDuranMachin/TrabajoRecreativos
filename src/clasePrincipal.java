import java.util.ArrayList;

public class clasePrincipal {

	static int numeroTarjetasCreadas = 0;
	static ArrayList<Tarjeta> listaUsuarios = new ArrayList<>();
	public static void addTestCase() {
		
		Tarjeta t = new Tarjeta(numeroTarjetasCreadas);
		numeroTarjetasCreadas++;
		listaUsuarios.add(t);
	}
	
	public static void main(String[] args) {

		addTestCase();
		addTestCase();
		System.out.println(listaUsuarios.get(0));
		System.out.println(listaUsuarios.get(1).info());
	
		listaUsuarios.get(1).setSaldoCreditos(30);
	}
}
