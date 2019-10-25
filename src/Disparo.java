import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Disparo extends GameObject {

	public Disparo(int d, Punto p) {
		danio = d;
		punto = p;
		vida = 20;
		rango = 0;
		
		ruta_dibujo = "aliados/disparo.gif";
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta_dibujo));
		dibujo = new JLabel(imagen);
		dibujo.setVisible(true);		
		ancho = 12; //dibujo.getWidth();
		largo = 12; //dibujo.getHeight();
		
	}

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(obj.getVida()-danio);
		if(obj.getVida()<=0)
			obj.morir();
		morir();
	}
	
}
