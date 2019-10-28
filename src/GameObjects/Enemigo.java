package GameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Disparos.Disparo;
import Disparos.DisparoEnemigo;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Enemigo extends GameObject   {
	
	protected int puntos;
	protected int monedas;
	
	public Enemigo(int vida, int danio, int rango, int velMov, int velAt, int puntos, int monedas) {
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.puntos = puntos;
		this.monedas = monedas;
	}	
	
	@Override
	public void atacar(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(frecuencia_ataques%velocidad_ataque == 0)
				iniciarAtaque(obj);
			frecuencia_ataques++;
		} else
			morir();
	}
	
	public void iniciarAtaque(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		Punto p = new Punto(punto.getX()-disparo.getAncho(), punto.getY()+(largo/2));
		disparo.setPunto(p);
		mapa.add(disparo);	
	}
	

	public void interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();
	}
	
	public void mover() {	
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_moviendose));		
		dibujo.setIcon(imagen);
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if( newX > 0 ) {
			newX = newX - velocidad_movimiento;		
			punto.setX(newX);
			dibujo.setLocation(newX, (int)rectangulo.getY());
		}
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
