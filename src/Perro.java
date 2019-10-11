import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo {
	
	
	public Perro() {
		punto = null;
		ancho = 62;
		largo = 38;
		vida = 40;
		danio = 10;
		rango = 1;
		//velocidad = RAPIDA
		puntos = 35;
		monedas = 30;	
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
		dibujo = new JLabel(imagen);
		//dibujo.setBounds(punto.getX(), punto.getY(), ancho, largo);	
		v = new VisitorEnemigo(this);
	}	
	
	public void interactuar() {			
		Rectangle pos = dibujo.getBounds();
		int newX = (int) pos.getX() - 1;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	

		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado == null)
			dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		else 
			this.accept(objIntersectado.getVisitor()); // lo visitan
	}

	@Override
	public void atacar(GameObject obj) {
		if(vida>0) {  // si estoy vivo, ataco
			obj.setVida(obj.getVida()-danio);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else
			morir();
	}
}
