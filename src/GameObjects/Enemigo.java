package GameObjects;

import java.awt.Rectangle;

import Visitor.Visitor;

public abstract class Enemigo extends Personaje   {
	
	protected int velocidad;
	protected int puntos;
	protected int monedas;
	
	
	public void mover() {	
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if( newX > 0 ) {
			newX = newX - velocidad_de_movimiento;		
			punto.setX(newX);
			dibujo.setLocation(newX, (int)rectangulo.getY());
		}
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
