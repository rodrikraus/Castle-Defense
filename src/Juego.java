import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

public class Juego {
	
	protected GUI gui;
	protected Oleada oleada;
	protected Movimiento movimiento;
	protected Mapa mapa;
	
	public Juego(){
		mapa = new Mapa();
		gui = new GUI();
		gui.setVisible(true);
		oleada = new Oleada();
		generarOleada();
		eliminarPerroBoton();
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
		mapa.agregarGameObject(aliado);
	}
	
	public void generarOleada(){
		LinkedList<Enemigo> listaEnemigo = oleada.enemigosToList();
		for(Enemigo e: listaEnemigo) {
			gui.agregarDibujo(e);			
		}	
	}	
	
	public void mover() {		
		LinkedList<Enemigo> listaEnemigo = oleada.getListaEnemigos();
		for(Enemigo e: listaEnemigo) 
			e.mover();
	}
	
	private void desaparecerObjeto( ) {
		Enemigo ene = oleada.getListaEnemigos().getFirst();
		JLabel labell = ene.getDibujo();
		labell.setVisible(false);
		oleada.getListaEnemigos().remove(oleada.getListaEnemigos().getFirst());		
	}
	
	public void eliminarPerroBoton() {
		gui.btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				desaparecerObjeto();	
				System.out.println("hoo"+oleada.getListaEnemigos().size());
			}
		});		
	}
}

