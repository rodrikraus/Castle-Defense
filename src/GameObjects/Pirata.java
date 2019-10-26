package GameObjects;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import Disparos.DisparoAliado;
import Juego.Punto;
import Visitor.VisitorAliado;

public class Pirata extends Aliado {

	protected int cantAtaques;

	
	public Pirata() {

		ruta_dibujo_quieto = "img/aliados/pirata.gif";
		ruta_dibujo_ataque = "img/aliados/pirata_ataque.gif";
		
		punto = null;
		vida = 40;
		danio = 10;
		rango = 200;
		costo = 160;		
		
		velocidad_de_movimiento = 0;
		velocidad_de_disparo = 20;
		cantAtaques = 0;	
		
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_quieto));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
		
		v = new VisitorAliado(this);
		
		
	}	

	@Override
	public void atacar(GameObject obj) {
		if(vida>0) {  // si estoy vivo, ataco		
			if(cantAtaques%velocidad_de_disparo == 0)
				disparar();
			cantAtaques++;
		} 
		else
			morir();
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			objIntersectado.accept(v);
		}
	}	
	
	public void disparar() {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));
		imagen.getImage().flush();  // el flush() vuelve a iniciar el gif
		dibujo.setIcon(imagen);
		
		Disparo disparo = new DisparoAliado(danio, new Punto(punto.getX()+80,punto.getY()+20), rango);
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);
	}

	@Override
	public void mover() {
		// los aliados no se mueven
	}
}
