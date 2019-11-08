package Juego;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Pirata;
import Tienda.Tienda;

public class Juego {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	protected Tienda tienda;
	int contadorDobleDanio;
	int contadorDobleOro;
	
	public Juego(){
		
		tienda = Tienda.Instancia(this);
		gui = new GUI(tienda);
		gui.setVisible(true);
		mapa = new Mapa(gui, this);
		gui.setMapa(mapa);
		mapa.crearNivelUno();
		movimiento = new Movimiento(this);
		movimiento.run();
		contadorDobleDanio = 0;
		contadorDobleOro = 0;
	}	

	public Mapa getMapa() {
		return mapa;
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	public void interactuar() {	
		boolean puedoSeguirMoviendome;

//		System.out.println("Tamaño lista principal: "+mapa.getListaPrincipal().size());
//		System.out.println("Tamaño lista eliminar: "+mapa.getListaEliminar().size());
//		System.out.println("Tamaño lista agregar: "+mapa.getListaAgregar().size());
	
		for(GameObject obj : mapa.getListaPrincipal()) {
			if(contadorDobleDanio > 0) {
				obj.setDobleDanio(true);
				System.out.println(contadorDobleDanio);
				contadorDobleDanio--;
			} else {
				obj.setDobleDanio(false);
			}
			
			if(contadorDobleOro > 0) {
				obj.setDobleOro(true);
				contadorDobleOro--;
			} else {
				obj.setDobleOro(false);
			}
		}
		
		for(GameObject obj : mapa.getListaPrincipal()) {
			if(obj.getVida()>0) {				/*
				obj.interactuar();
				*/
				puedoSeguirMoviendome = obj.interactuar();
				if( !puedoSeguirMoviendome ) 
					finDelJuego();
			}			
			else
				obj.morir();
		}
		
		for(GameObject obj : mapa.getListaEliminar()) {
			tienda.sumarMonedas(obj.getMonedas());
			mapa.getListaPrincipal().remove(obj);
			obj.getDibujo().setVisible(false);
			obj = null;
		}
		mapa.resetLista(mapa.getListaEliminar());
		
		
		for(GameObject obj : mapa.getListaAgregar()) {
			mapa.getListaPrincipal().add(obj);
			gui.agregarDibujo(obj);
			obj.setMapa(mapa);
		}		
		mapa.resetLista(mapa.getListaAgregar());
		
	}
	
	private void finDelJuego() {
		movimiento.setDeboMover(false);
		gui.gameOver();
		
	}

	public void activarContadorDobleDanio() {
		contadorDobleDanio = 5000;
	}

	public void activarContadorDobleOro() {
		contadorDobleOro = 5000;
	}
	
}

