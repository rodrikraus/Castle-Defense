package GameObjects.Disparos;

import java.awt.Rectangle;

import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int danio, Punto punto, int rango) {
		super(danio, punto, rango);
		visitor = new VisitorDisparoEnemigo(this);
	}
	
	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 

	public void mover() {	
		rango = rango - velocidad_movimiento;
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if( newX > 0 && rango>0 ) {
			newX = newX - velocidad_movimiento;		
			punto.setX(newX);
			dibujo.setLocation(newX, (int)rectangulo.getY());
		} else 
			morir();
	}
	

}
