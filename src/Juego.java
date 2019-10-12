import java.util.LinkedList;
import java.util.Random;

public class Juego {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	protected Tienda tienda;
	
	public Juego(){ 
		gui = new GUI(tienda);
		gui.setVisible(true);
		mapa = new Mapa(gui);
		crearAliado();
		mapa.crearNivelUno();
		
		tienda = new Tienda(this);
		movimiento = new Movimiento(this);
		movimiento.run();	
	}	

	public Mapa getMapa() {
		return mapa;
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	private void crearAliado() {
		Random random = new Random();
		int x = 100;
		int y = 220;
		Punto punto = new Punto(x, y);
		Aliado aliado = new Pirata();
		aliado.setPunto(punto);
		gui.agregarDibujo(aliado);
		mapa.getListaPrincipal().add(aliado);
		aliado.setMapa(mapa);
	}
	
	public void interactuar() {	
		
		for(GameObject obj : mapa.getListaPrincipal()) {
			if(obj.getVida()>0)
				obj.interactuar();
			else
				obj.morir();
		}
		for(GameObject obj : mapa.getListaEliminar()) { 
			mapa.getListaPrincipal().remove(obj);
			obj.getDibujo().setVisible(false);
			obj = null;
		}
		mapa.resetLista(mapa.getListaEliminar());
		
		
		for(GameObject obj : mapa.getListaAgregar()) {
			mapa.getListaPrincipal().add(obj);
		}
		mapa.resetLista(mapa.getListaAgregar());
	}
}

