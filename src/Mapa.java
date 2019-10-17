import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mapa {

	protected GUI gui;
	protected static List<GameObject> lista_principal;
	protected static List<GameObject> lista_a_agregar;
	protected static List<GameObject> lista_a_eliminar;
	
	
	public Mapa(GUI g) {
		lista_principal = new LinkedList<GameObject>();
		lista_a_agregar = new LinkedList<GameObject>();
		lista_a_eliminar = new LinkedList<GameObject>();
		gui = g;
	}

	public void resetLista(List<GameObject> l) {
		l = new LinkedList<GameObject>();
	}	
	
	public List<GameObject> getListaPrincipal() {
		return lista_principal;
	}
	public List<GameObject> getListaAgregar() {
		return lista_a_agregar;
	}
	public List<GameObject> getListaEliminar() {
		return lista_a_eliminar;
	}
	
	/*
	public GameObject estoyEnRangoDeAlguien(GameObject obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		for(GameObject elem : lista_principal) {
			Rectangle tamanioElem = elem.getDibujo().getBounds();
			tamanioElem.width += elem.getRango();
			
		}
		return null;
	}
	*/
	
	public GameObject intersectaObjeto(GameObject obj) {
		for(GameObject elem : lista_principal)
			if(obj!=elem && elem.getDibujo().getBounds().intersects(obj.getDibujo().getBounds()))
					return elem;
		return null;
	}
	
	public GameObject intersectaRango(GameObject obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.width += obj.getRango();
		for(GameObject elem : lista_principal) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	
	public void crearNivelUno(){
		Random random = new Random();
		
		// fijo el x,y para tester, lo correcto sería usar el random de mas abajo
		int x = 500; 
		int y = 230;
		
		//int x = 400 + random.nextInt(600 - 400 );
		//int y = 200 + random.nextInt(300 - 200);
		Punto punto = new Punto(x,y);
		Enemigo enemigo = new Perro();
		enemigo.setPunto(punto);
		lista_principal.add(enemigo);
		enemigo.setMapa(this);
		gui.agregarDibujo(enemigo);
	}
	
	public void crearNivelDos() {
	
	}
}
