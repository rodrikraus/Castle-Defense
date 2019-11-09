package GameObjects.ObjetosMapa.PorVida;

import GameObjects.ObjetosMapa.ObjetoMapaVida;
import Juego.Punto;
import Visitor.VisitorObjetoMapa;

public class Barricada extends ObjetoMapaVida {
	
	public Barricada(Punto p){
		super(60);
		punto = p;
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto = "img/mapa/barricada.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}

}
