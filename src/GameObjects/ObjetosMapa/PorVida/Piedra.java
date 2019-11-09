package GameObjects.ObjetosMapa.PorVida;

import GameObjects.ObjetosMapa.ObjetoMapaVida;
import Juego.Punto;
import Visitor.VisitorObjetoMapa;

public class Piedra extends ObjetoMapaVida {
	
	public Piedra(Punto p){
		super(40);
		punto = p;
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto = "img/mapa/piedra.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}


}
