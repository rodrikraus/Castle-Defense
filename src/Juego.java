import java.util.Random;

public class Juego {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	
	public Juego(){ 
		gui = new GUI();
		gui.setVisible(true);
		mapa = new Mapa(gui);
		mapa.crearNivelUno();
		crearAliado();
		movimiento = new Movimiento(this);
		movimiento.run();	
	}	

	private void crearAliado() {
		Random random = new Random();
		int x = 100;
		int y = 220;
		Punto punto = new Punto(x, y);
		Aliado aliado = new Pirata(punto);
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
			mapa.getListaEliminar().remove(obj);
			obj.getDibujo().setVisible(false);
			obj = null;
		}
		
		for(GameObject obj : mapa.getListaAgregar()) {
			mapa.getListaPrincipal().add(obj);
			mapa.getListaAgregar().remove(obj);
		}
	}
}

