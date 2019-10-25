
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int danio, Punto p, int r) {
		super(danio, p, r);
		v = new VisitorDisparoAliado(this);
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 

	public void mover() {		
		Rectangle pos = dibujo.getBounds();
		
		int newX = (int) ((pos.getX()>0)? pos.getX()+velocidad_de_movimiento : pos.getX());
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
		mover();
//		Rectangle pos = dibujo.getBounds();
//		int newX = (int) pos.getX()+3;
//		int newY = (int) pos.getY();
//		int ancho = (int) pos.getWidth();
//		int alto = (int) pos.getHeight();	
//		punto.setX(newX);
//		punto.setY(newY);
//		dibujo.setLocation(newX, newY);
		
		GameObject objIntersectado = mapa.intersectaObjeto(this);
//		dibujo.setBounds(newX, newY, ancho, alto); // se mueve
//		System.out.println("Disparo aliado.interactuar()");
		
		//	System.out.println("disparo se mueve");
		
		
			//this.accept(objIntersectado.getVisitor()); // lo visitan

		//	System.out.println("Disparo Aliado accept - obj intersecado: "+objIntersectado.getClass().toString());

			if(objIntersectado != null) {
				objIntersectado.accept(v);
			}
		
	}
	
}
