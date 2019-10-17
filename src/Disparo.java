import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Disparo extends GameObject {

	public Disparo(int danio, Punto p) {
		punto = p;
		this.danio = danio + 100;
		ancho = 12;
		largo = 12;
		vida = 40;
		rango = 0;

		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/disparo.gif"));
		dibujo = new JLabel(imagen);
		//dibujo.setBounds(punto.getX(), punto.getY(), ancho, largo);
		dibujo.setVisible(true);
		
	}

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(obj.getVida()-danio);
		if(obj.getVida()<=0)
			obj.morir();
		morir();
	}
}
