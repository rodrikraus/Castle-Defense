import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo {
	
	
	public Perro(Punto punto) {
		ubicacion = punto;
		ancho = 62;
		largo = 38;
		vida = 30;
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
		dibujo = new JLabel(imagen);
		rango = 1;
		danio = 10;
		//velocidad = RAPIDA
		puntos = 35;
		monedas = 30;	
		dibujo.setBounds(ubicacion.getX(), ubicacion.getY(), ancho, largo);	
		
	}
	
	public int getAncho() {
		return ancho;
	}

	public int getLargo() {
		return largo;
	}
	
	
	
	public void mover() {		
		Rectangle pos = dibujo.getBounds();		
		int newX = (int) pos.getX() - 1;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	
		dibujo.setBounds(newX, newY, ancho, alto);	
	}
	
	public void morir() {
		dibujo.setVisible(false); // no se si ésto funca
	}
	
}
