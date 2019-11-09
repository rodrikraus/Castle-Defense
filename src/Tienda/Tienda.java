package Tienda;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

import GameObjects.GameObject;
import GameObjects.Premios.ObjectosPreciosos.Bomba;
import GameObjects.Premios.ObjectosPreciosos.Dinamita;
import Juego.Juego;

public class Tienda {
	
	// PATRON SINGLETON
	private static Tienda instancia = null;
	
	protected Juego juego;
	protected GameObject toAdd;
	protected int monedas;
	protected List<JButton> listaBotones;
	protected int newMonedas;
	protected boolean botonesActivos;
	protected boolean puedoVender;
	protected Dinamita dinamita;
	protected Bomba bomba;
	

	private Tienda(Juego j){
		juego = j;
		toAdd = null;
		monedas = 50;
		botonesActivos = true;
		puedoVender = true;
		dinamita = null;
		bomba = null;
		
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
		
		estadoBotones(true);
	}
	
	
	public static Tienda Instancia(Juego juego) {
		if(instancia==null)
			instancia = new Tienda(juego);
		return instancia;
		
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
		
	// Si es TRUE se activan solo los que se pueden activar
	// Si es FALSE se desactivan todos
	public void estadoBotones(boolean estado) {
		botonesActivos = estado;
		for(JButton boton : listaBotones) {
			if(((BotonFactory) boton).getCosto() > monedas) 
				boton.setEnabled(false);			
			else 
				boton.setEnabled(estado);
		}
	}
	
	
	public void setMonedas(int i) {
		monedas = i;
		juego.getGUI().actualizarMonedas();
		estadoBotones(true);
		
	}
	
	public void sumarMonedas(int i) {
		monedas = monedas + i;
		juego.getGUI().actualizarMonedas();
		if(botonesActivos)
			estadoBotones(true);
	}
	

	public void restarMonedas(int i) {
		monedas = monedas - i;
		juego.getGUI().actualizarMonedas();
		if(botonesActivos)
			estadoBotones(true);
	}
	
	public void setPuedoVender(boolean b) {
		juego.getGUI().setEstadoBotonVender(!b);
		puedoVender = b;
	}
	
	public boolean getPuedoVender() {
		return puedoVender;
	}
	

	public Dinamita getDinamita() {
		return dinamita;
	}

	public void setDinamita(Dinamita dinamita) {
		this.dinamita = dinamita;
	}

	public Bomba getBomba() {
		return bomba;
	}


	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

	
}
