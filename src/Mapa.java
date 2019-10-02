import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class Mapa {

	// Lista que almacena todos los objetos que hay en el mapa
	protected static List<GameObject> lista;
	
	
	public Mapa() {
		lista = new LinkedList<GameObject>();
	}
	
	public List<GameObject> getLista() {
		return lista;
	}
		
	public void agregarGameObject(GameObject obj) {
		lista.add(obj);
	}
	
	public GameObject intersectaObjeto(GameObject obj) {
		for(GameObject elem : lista)
			if(elem.getDibujo().getBounds().intersects(obj.getDibujo().getBounds()))
				return elem;
		return null;
	}
	
	public GameObject intersectaRango(GameObject obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.width += obj.getRango();
		for(GameObject elem : lista) {
			if(elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
}
