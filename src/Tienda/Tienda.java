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
	protected List<JButton> listaBotones;
	protected int newMonedas;
	
	public Tienda(Juego j){
		juego = j;
		toAdd = null;
		monedas = 500;
		
		listaBotones = new LinkedList<JButton>();

		JButton btn_pirata = new BotonPirata(this, juego.getMapa());
		JButton btn_ninja = new BotonNinja(this, juego.getMapa());
		JButton btn_maga = new BotonMaga(this, juego.getMapa());
		JButton btn_guerrero = new BotonGuerrero(this, juego.getMapa());
		JButton btn_golem = new BotonGolem(this, juego.getMapa());
	
		listaBotones.add(btn_pirata);
		listaBotones.add(btn_ninja);
		listaBotones.add(btn_maga);
		listaBotones.add(btn_guerrero);
		listaBotones.add(btn_golem);		
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
		return listaBotones;
	}
	
	public int getMonedas() {
		return monedas;
	}
	
	public void actualizarEstadoBotones() {
		for(JButton boton : listaBotones)
			if(((BotonFactory) boton).getCosto() > monedas)
				boton.setEnabled(false);
			else
				boton.setEnabled(true);
	}
	
	public void estadoBotones(boolean estado) {
		for(JButton boton : listaBotones)
			if(((BotonFactory) boton).getCosto() > monedas)
				boton.setEnabled(false);
			else
				boton.setEnabled(estado);
	}
	
	
	public void setMonedas(int i) {
		monedas = i;
		juego.getGUI().actualizarMonedas();
		
	}

	public int getNewMonedas() {
		return newMonedas;
	}
	
	public void setNewMonedas(int newMonedas) {
		this.newMonedas = newMonedas;
	}


	public void actualizarMonedas() {
		monedas = newMonedas;
		juego.getGUI().actualizarMonedas();
	}
	
}
