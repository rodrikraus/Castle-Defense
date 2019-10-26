package GameObjects;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import Disparos.DisparoAliado;
import Disparos.DisparoEnemigo;
import Juego.Punto;
import Visitor.VisitorEnemigo;

public class Perro extends Enemigo {
		
	public Perro() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Puntos, Monedas
		super(40, 5, 100, 3, 20, 35, 30);
		visitor = new VisitorEnemigo(this);
				
		ruta_dibujo_quieto = null;
		ruta_dibujo_moviendose = "img/enemigos/perro.gif";
		ruta_dibujo_ataque = "img/enemigos/perro_ataque.gif";

		cambiarDibujo(ruta_dibujo_moviendose);
	}	
	
	public void interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();
	}

	@Override
	public void atacar(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(frecuencia_ataques%velocidad_ataque == 0)
				disparar();
			frecuencia_ataques++;
		} else
			morir();
	}
	

	public void disparar() {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		Punto p = new Punto(punto.getX()+disparo.getAncho(), punto.getY()+(largo/2));
		disparo.setPunto(p);
		mapa.add(disparo);	
	}
}
