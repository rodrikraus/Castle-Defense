import java.util.Random;

public class Juego {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	protected Tienda tienda;
	
	public Juego(){
		tienda = new Tienda(this); 
		gui = new GUI(tienda);
		gui.setVisible(true);
		mapa = new Mapa(gui);
		crearAliado();
		crearAliado1();
		mapa.crearNivelUno();
		
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
		//crearDisparo(aliado.getDanio(), aliado.getPunto());
	}
	

	private void crearAliado1() {
		Random random = new Random();
		int x = 100-77;
		int y = 220;
		Punto punto = new Punto(x, y);
		Aliado aliado = new Pirata();
		aliado.setPunto(punto);
		gui.agregarDibujo(aliado);
		mapa.getListaPrincipal().add(aliado);
		aliado.setMapa(mapa);
		//crearDisparo(aliado.getDanio(), aliado.getPunto());
	}
	
	public void crearDisparo(int danio, Punto punto){
		Disparo disparo = new DisparoAliado(danio, new Punto(punto.getX()+74,punto.getY()+20));
		gui.agregarDibujo(disparo);
		mapa.getListaPrincipal().add(disparo);
		disparo.setMapa(mapa);
	}
	
	public void interactuar() {	
/*
		System.out.println("Tamaño lista principal: "+mapa.getListaPrincipal().size());
		System.out.println("Tamaño lista eliminar: "+mapa.getListaEliminar().size());
		System.out.println("Tamaño lista agregar: "+mapa.getListaAgregar().size());
	*/	
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
			gui.agregarDibujo(obj);
			//obj.setMapa(mapa);
		}
		mapa.resetLista(mapa.getListaAgregar());
		
		
	}
}

