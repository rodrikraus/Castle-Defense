import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Oleada {
	
	protected LinkedList<Enemigo> listaEnemigos;
	
	public Oleada(){
		listaEnemigos=new LinkedList<Enemigo>();
		
	}

	public LinkedList<Enemigo> enemigosToList(){
		Random random = new Random();
		int x = 400 + random.nextInt(600 - 400 );
		int y = 200 + random.nextInt(300 - 200);
		Punto punto = new Punto(x, y);
		Enemigo enemigo = new Perro(punto);
		listaEnemigos.add(enemigo);
		return listaEnemigos;		
	}
	
	public void eliminarEnemigo(Enemigo e) {
		listaEnemigos.remove(e);
		
	}
	
	public LinkedList<Enemigo> getListaEnemigos(){
		return listaEnemigos;
	}
}
