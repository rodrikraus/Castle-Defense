import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Disparo extends GameObject {

	public Disparo(int danio, Punto p) {
		punto = p;
		this.danio = danio+100;
		ancho = 60;
		largo = 60;
		vida = 40;
		rango = 0;
		v = new VisitorDisparo(this);

		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/pirata_bala.png"));
		dibujo = new JLabel(imagen);
		//dibujo.setBounds(punto.getX(), punto.getY(), ancho, largo);
		//dibujo.setVisible(true);
		
	}
	
	@Override
	public void accept(Visitor v){
		v.visitDisparo(this);  
	} 

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(obj.getVida()-danio);
		morir();
	}
	

	@Override
	public void interactuar() {		
		Rectangle pos = dibujo.getBounds();
		int newX = (int) pos.getX()+1;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	

		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado == null)
			dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		else 
			this.accept(objIntersectado.getVisitor()); // lo visitan
	}

}
