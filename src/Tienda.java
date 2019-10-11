
public class Tienda {
	
	protected Juego juego;
	protected GameObject toAdd;
	protected int monedas;
	
	public Tienda(Juego j){
		juego = j;
		agregarBotones();
		toAdd = null;
	}
	

	public void setToAdd(GameObject obj) {
		toAdd = obj;
	}
	
	public GameObject getToAdd() {
		return toAdd;
	}
	
	public Juego getJuego() {
		return juego;
	}

	private void agregarBotones() {
		BotonPirata btn_pirata = new BotonPirata(this, juego.getMapa());
		// seguir creando demas botones ...
		
	}
	
}
