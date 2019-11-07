package Juego;
import java.util.Random;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Pirata;
import Tienda.Tienda;

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
		gui.setMapa(mapa);
		//crearAliado();
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
		int x = 100;
		int y = 200;
		Punto punto = new Punto(x, y);
		Aliado aliado = new Pirata();
		aliado.setPunto(punto);
		mapa.add(aliado);
		aliado.setMapa(mapa);
	}
	
	public void interactuar() {	

//		System.out.println("Tamaño lista principal: "+mapa.getListaPrincipal().size());
//		System.out.println("Tamaño lista eliminar: "+mapa.getListaEliminar().size());
//		System.out.println("Tamaño lista agregar: "+mapa.getListaAgregar().size());
	
		for(GameObject obj : mapa.getListaPrincipal()) {
			if(obj.getVida()>0) {
				
				/*
				obj.interactuar();
				*/
				boolean noEsFin;
				noEsFin=obj.interactuar();
				if (noEsFin==false) {
					finDelJuego();
				}
				
			}			
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
			obj.setMapa(mapa);
		}		
		mapa.resetLista(mapa.getListaAgregar());
		
	}
	
	private void finDelJuego() {
		System.out.println("PERDISTE BOBOLON");	
		gui.gameOver();
		
	}
	
}

