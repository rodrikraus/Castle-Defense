package GameObjects.Disparos;

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
		
		ruta_dibujo_quieto = "img/disparos/disparo_angosto.gif";
		ruta_dibujo_ataque = null;
		ruta_dibujo_moviendose = null;
		
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_quieto));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}
	
	@Override
	/*public void interactuar() {
		mover();
		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado != null) 
			objIntersectado.accept(visitor);	
	}*/
	
	public boolean interactuar() {
	mover();
	GameObject objIntersectado = mapa.intersectaObjeto(this);
	if(objIntersectado != null) 
		objIntersectado.accept(visitor);	
	return true;
	}

	@Override
	public void atacar(GameObject obj) {
		iniciarAtaque(obj);
		if(obj.getVida()<=0)
			obj.morir();
		morir();
	}
	
	@Override
	public void iniciarAtaque(GameObject obj) {
		obj.setVida(obj.getVida()-danio); // los disparos hacen daño directamente		
	}	


	@Override
	// Que pasa cuando se le hace click ??
	public int toClick() {
		return 0;
	}

}
