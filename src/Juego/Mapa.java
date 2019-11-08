package Juego;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import GameObjects.GameObject;
import GameObjects.Enemigos.*;

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

	public GUI getGui() {
		return gui;
	}
	
	public void add(GameObject obj) {
		lista_a_agregar.add(obj);
	}
	
	
	public void resetLista(List<GameObject> l) {
		l.clear();
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
	
	public boolean puedoAgregarObjeto(GameObject obj) {
		boolean puedoInsertar = true;
		
		if( obj == null )
			return false;
		
		int x = obj.getPunto().getX();
		int y = obj.getPunto().getY();
		int ancho = obj.getAncho();
		int largo = obj.getLargo();
		Rectangle rec = new Rectangle(x, y, ancho, largo);	
		
		for(GameObject elem : lista_principal)
			if(elem.getDibujo().getBounds().intersects(rec)) {
				puedoInsertar = false;	
				return false;
			}
		
		return puedoInsertar;
	}
		
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
	
	public GameObject intersectaRangoDeEnemigo(GameObject obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.translate(-obj.getRango(),0);
		tamanioObj.width += obj.getRango();
		for(GameObject elem : lista_principal) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	
	public void crearNivelUno(){
		Random random = new Random();
		
		String oleadas = "ppjbpv jpjjpbm bjppd"; //v m y d son los bosses finales de cada oleada
													//entonces cada vez q muera alguno cambia la oleada o (si es d) ganas.
		int contador = 700;
		final int ESPACIOENTREENEMIGOS = 200;
		final int ALTURA = 150;
		
		for(int i = 0; i < oleadas.length(); i++) {
			switch(oleadas.charAt(i)) {
				case '2': { // Muestro oleada 2
					gui.mostrarOleada2();
					break;
				}
				
				case '3': { // Muestro oleada 3
					gui.mostrarOleada3();
					break;
				}
				
				case 'p': { // Creo un perro
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Perro();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
			
				case 'd': { // Creo un dragon
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Dragon();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
			
				case 'j': { // Creo un jabali
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Jabali();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
				case 'm': { // Creo un mono
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Mono();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
				
				case 'b': { // Creo un monstruo violeta
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Violeta();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
				
				case 'v': { // Creo una vampira
					Punto punto = new Punto(contador, random.nextInt(ALTURA));
					Enemigo enemigo = new Vampira();
					enemigo.setPunto(punto);
					add(enemigo);
					enemigo.setMapa(this);
					contador += ESPACIOENTREENEMIGOS;
					break;
				}
			}
		}
	}
	
	public void mostrarOleada2() {
		gui.mostrarOleada2();
	}
	
	public void mostrarOleada3() {
		gui.mostrarOleada3();
	}
	
	public void mostrarPantallaGanadora() {
		gui.gameOver();
	}

}
