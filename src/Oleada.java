import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Oleada {
	
	protected Enemigo [] arreglo;
	protected List<Enemigo> miLista=new LinkedList<>();
	
	public Oleada(){
		arreglo= new Enemigo[1];	
		//miLista.
	}

	public Enemigo[] oleada1(){		
		Random random = new Random();
		int x = 400 + random.nextInt(600 - 400 );
		int y = 200 + random.nextInt(300 - 200);
		Punto punto = new Punto(x, y);
		Enemigo enemigo = new Perro(punto);
		arreglo[0] = enemigo;
		return arreglo;
	}
	
	public Enemigo[] getArreglo() {
		return arreglo;
	}
}
