package Disparos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;


public abstract class Disparo extends GameObject {

	public Disparo(int danio, Punto punto, int rango) {
		// vida, danio, rango, velocidad de movimiento
		super(20, danio, rango, 3);
		this.punto = punto;
		
		ruta_dibujo_quieto = "img/disparos/disparo.gif";
		
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_quieto));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(obj.getVida()-danio);
		if(obj.getVida()<=0)
			obj.morir();
		morir();
	}

	@Override
	public void interactuar() {
		mover();
		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado != null) 
			objIntersectado.accept(visitor);	
	}
}
