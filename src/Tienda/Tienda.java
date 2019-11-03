package Tienda;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

import GameObjects.GameObject;
import Juego.Juego;

public class Tienda {
	
	protected Juego juego;
	protected GameObject toAdd;
	protected int monedas;
	
	public Tienda(Juego j){
		juego = j;
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

	public List<JButton> getListaBotones() {
		List<JButton> toReturn = new LinkedList<JButton>();
		
		JButton btn_pirata = new BotonPirata(this, juego.getMapa());
		JButton btn_ninja = new BotonNinja(this, juego.getMapa());
		JButton btn_maga = new BotonMaga(this, juego.getMapa());
		JButton btn_guerrero = new BotonGuerrero(this, juego.getMapa());
		JButton btn_golem = new BotonGolem(this, juego.getMapa());
		

		toReturn.add(btn_pirata);
		toReturn.add(btn_ninja);
		toReturn.add(btn_maga);
		toReturn.add(btn_guerrero);
		toReturn.add(btn_golem);
		
		
		return toReturn;
	}
	
}
