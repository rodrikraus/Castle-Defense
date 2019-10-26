package GameObjects;
import java.awt.Rectangle;

import javax.swing.JLabel;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public abstract class GameObject {
	
	protected int vida;
	protected Punto punto;
	protected JLabel dibujo;
	protected int ancho; 
	protected int largo; 
	protected Visitor v;
	protected Mapa mapa;
	protected int rango;
	protected int danio;
	protected int velocidad_de_movimiento;
	protected int velocidad_de_disparo;
	
	protected String ruta_dibujo_quieto;
	protected String ruta_dibujo_moviendose;
	protected String ruta_dibujo_ataque;
	
	
	public int getVelocidad_de_movimiento() {
		return velocidad_de_movimiento;
	}
	
	public abstract void mover();
	
	public int getDanio() {
		return danio;
	}
	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public int getRango() {
		return rango;
	}
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Punto getPunto() {
		return punto;
	}
	public void setPunto(Punto p) {
		punto = p;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	public void setDibujo(JLabel dibujo) {
		this.dibujo = dibujo;
	}
	public int getAncho() {
		return ancho;
	}
	
	public int getLargo() {
		return largo;
	}	
	
	public abstract void accept(Visitor v);
	
	public abstract void atacar(GameObject obj); 

	public abstract void interactuar();

	public Visitor getVisitor() {
		return v;
	}
	
	public void morir() {
		mapa.getListaEliminar().add(this);
		//System.out.println("MURIÓ "+this.getClass().toString());
	}
}
