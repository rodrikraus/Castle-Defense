package Disparos;

import java.awt.Rectangle;

import GameObjects.GameObject;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int danio, Punto p, int r) {
		super(danio, p, r);
		v = new VisitorDisparoEnemigo(this);
	}


	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 

	public void mover() {		
		Rectangle pos = dibujo.getBounds();
		
		int newX = (int) ((pos.getX()>0)? pos.getX()-velocidad_de_movimiento : pos.getX());
		int newY = (int) pos.getY();
//		int ancho = (int) pos.getWidth();
//		int alto = (int) pos.getHeight();
		punto.setX(newX);
//		dibujo.setBounds(newX, newY, ancho, alto);
		dibujo.setLocation(newX, newY);
		
		

		rango = rango - velocidad_de_movimiento;
		if(rango<=0)
			morir();
	}
	
	@Override
	public void interactuar() {		
//		Rectangle pos = dibujo.getBounds();
//		int newX = (int) pos.getX()-3;
//		int newY = (int) pos.getY();
//		int ancho = (int) pos.getWidth();
//		int alto = (int) pos.getHeight();	
		mover();
		GameObject objIntersectado = mapa.intersectaObjeto(this);
		
		//dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		if(objIntersectado != null) {
			objIntersectado.accept(v);
		}
	}

}
