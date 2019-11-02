package Juego;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import GameObjects.Enemigo;
import GameObjects.GameObject;
import GameObjects.Perro;

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
		
		// fijo el x,y para tester, lo correcto sería usar el random de mas abajo
		int x = 500; 
		int y = 200;
		
		//int x = 400 + random.nextInt(600 - 400 );
		//int y = 200 + random.nextInt(300 - 200);
		Punto punto = new Punto(x,y);
		Enemigo enemigo = new Perro();
		enemigo.setPunto(punto);
		//lista_principal.add(enemigo);
		add(enemigo);
		enemigo.setMapa(this);
		
		
/*
		Punto punto1 = new Punto(600,100);
		Enemigo enemigo1 = new Perro();
		enemigo1.setPunto(punto1);
		lista_principal.add(enemigo1);
		enemigo1.setMapa(this);
		gui.agregarDibujo(enemigo1);
		*/
	}
	
	public void crearNivelDos() {
	
	}
}
