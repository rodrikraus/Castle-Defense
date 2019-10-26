package Disparos;

import java.awt.Rectangle;

import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int danio, Punto punto, int rango) {
		super(danio, punto, rango);
		v = new VisitorDisparoAliado(this);
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 

	public void mover() {	
		rango = rango - velocidad_de_movimiento;
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if( newX < mapa.getGui().getRectanglePanelCesped().width && rango>0) {
			newX = newX + velocidad_de_movimiento;		
			punto.setX(newX);
			dibujo.setLocation(newX, (int)rectangulo.getY());
		} else 
			morir();
	}	
}
