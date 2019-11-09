package Juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import GameObjects.GameObject;
import GameObjects.Enemigos.*;

import GameObjects.ObjetosMapa.PorTiempo.Acido;
import GameObjects.ObjetosMapa.PorTiempo.Fuego;
import GameObjects.ObjetosMapa.PorVida.Barricada;
import GameObjects.ObjetosMapa.PorVida.Piedra;

public class Mapa {

	protected GUI gui;
	protected Juego juego;
	protected static List<GameObject> lista_principal;
	protected static List<GameObject> lista_a_agregar;
	protected static List<GameObject> lista_a_eliminar;
	Random random;
	private static String oleadas = "vvvppjbpv jpjjpbm bjppd"; //v m y d son los bosses finales de cada oleada (OBLIGATORIO ESE ORDEN)
    //entonces cada vez q muera alguno cambia la oleada o (si es d) ganas.
	
	
	
	public Mapa(GUI g, Juego j) {
		lista_principal = new LinkedList<GameObject>();
		lista_a_agregar = new LinkedList<GameObject>();
		lista_a_eliminar = new LinkedList<GameObject>();
		gui = g;
		juego = j;
		random = new Random();
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
		
	public List<GameObject> todosLosQueIntersecta(GameObject obj){
		List<GameObject> lista = new LinkedList<GameObject>();		
		for(GameObject elem : lista_principal)
			if(obj!=elem && elem.getDibujo().getBounds().intersects(obj.getDibujo().getBounds()))
				lista.add(elem);				
		return lista;
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
		int contador = 700;
		final int ESPACIOENTREENEMIGOS = 300;
		final int ESPACIOENTREOLEADAS = 600;
		final int ALTURA = 150;
		
		for(int i = 0; i < oleadas.length(); i++) {
			switch(oleadas.charAt(i)) {	
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
					contador += ESPACIOENTREOLEADAS;
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
					contador += ESPACIOENTREOLEADAS;
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
					contador += ESPACIOENTREOLEADAS;
					break;
				}
			}
		}
	}
	
	public void mostrarOleada2() {
		gui.mostrarOleada2();
		
		// Creo 2 objetos del mapa random
		int generarObjeto = random.nextInt(4);
		
		// Hasta encontrar un lugar valido, avanzo 50 pixeles a la derecha
		Punto punto = new Punto(random.nextInt(400), random.nextInt(150));
		while(intersectaPunto(punto) != null)
			punto.setX(punto.getX() + 50);
		
		switch(generarObjeto) {
			case 0: { // Creo una vampira
				GameObject objetoMapa = new Acido();
				objetoMapa.setPunto(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 1: { // Creo una vampira
				GameObject objetoMapa = new Fuego();
				objetoMapa.setPunto(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 2: { // Creo una vampira
				GameObject objetoMapa = new Barricada(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 3: { // Creo una vampira
				GameObject objetoMapa = new Piedra(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
		}
		
		
	}
	
	public void mostrarOleada3() {
		gui.mostrarOleada3();
		
		// Creo 2 objetos del mapa random
		int generarObjeto = random.nextInt(4);
		
		// Hasta encontrar un lugar valido, avanzo 50 pixeles a la derecha
		Punto punto = new Punto(random.nextInt(400), random.nextInt(150));
		while(intersectaPunto(punto) != null)
			punto.setX(punto.getX() + 50);
		
		switch(generarObjeto) {
			case 0: { // Creo una vampira
				GameObject objetoMapa = new Acido();
				objetoMapa.setPunto(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 1: { // Creo una vampira
				GameObject objetoMapa = new Fuego();
				objetoMapa.setPunto(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 2: { // Creo una vampira
				GameObject objetoMapa = new Barricada(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
			
			case 3: { // Creo una vampira
				GameObject objetoMapa = new Piedra(punto);
				add(objetoMapa);
				objetoMapa.setMapa(this);
				break;
			}
		}			
	}
	
	public void mostrarPantallaGanadora() {
		gui.youWin();
	}
	
	public GameObject intersectaClickConGameObject(Punto p) {
		Rectangle rec = new Rectangle(p.getX()-7, p.getY()-7, 14, 14);
		for(GameObject elem : lista_principal)
			if(elem.getDibujo().getBounds().intersects(rec))
					return elem;
		return null;
	}
	
	public GameObject intersectaPunto(Punto p) {
		Rectangle rec = new Rectangle(p.getX(), p.getY(), 50, 50);
		for(GameObject elem : lista_principal)
			if(elem.getDibujo().getBounds().intersects(rec))
					return elem;
		return null;
	}
	
	public Juego getJuego() {
		return juego;
	}

}
