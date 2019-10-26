package Disparos;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Punto;


public abstract class Disparo extends GameObject {

	public Disparo(int danio, Punto punto, int rango) {
		this.danio = danio;
		this.punto = punto;
		this.rango = rango;
		velocidad_de_movimiento = 3;
		vida = 20;
		
		
		ruta_dibujo_quieto = "img/disparos/disparo.gif";
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_quieto));
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
