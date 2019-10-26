package GameObjects;
import java.awt.Rectangle;

import Juego.Personaje;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje   {
	
	protected int velocidad;
	protected int puntos;
	protected int monedas;
	
	
	public void mover() {	
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if(rectangulo.getX()>0 && rectangulo.getX()<686) // si estoy dentro del panel
			newX = (int) (rectangulo.getX()-velocidad_de_movimiento);
			
		int newY = (int) rectangulo.getY();
//		int largo = (int) rectangulo.getWidth();
//		int alto = (int) rectangulo.getHeight();
		punto.setX(newX);
//		dibujo.setBounds(newX, newY, ancho, largo);
		dibujo.setLocation(newX, newY);
	}
	
	public abstract void interactuar();
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	} 

}
