package GameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import Disparos.DisparoEnemigo;
import Juego.Punto;
import Visitor.VisitorEnemigo;

public class Perro extends Enemigo {
	
	protected int cantDisparos;
	
	
	public Perro() {

		ruta_dibujo_moviendose = "img/enemigos/perro.gif";
		ruta_dibujo_ataque = "img/enemigos/perro_ataque.gif";
		
		punto = null;
		vida = 40;
		danio = 10;
		rango = 100;
		velocidad_de_movimiento = 3;
		velocidad_de_disparo = 10;
		puntos = 35;
		monedas = 30;	
		
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_moviendose));
		dibujo = new JLabel(imagen);	
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
		
		v = new VisitorEnemigo(this);
		cantDisparos = 0;
	}	
	
	public void interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(v);
		else
			mover();
	}

	@Override
	public void atacar(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(cantDisparos%velocidad_de_disparo == 0)
				disparar();
			cantDisparos++;
		} else
			morir();
	}
	

	public void disparar() {
		Disparo disparo = new DisparoEnemigo(danio, new Punto(punto.getX()-dibujo.getWidth(),punto.getY()+20), rango);
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);		
	}
}
