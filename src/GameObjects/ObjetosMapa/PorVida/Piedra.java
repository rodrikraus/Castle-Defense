package GameObjects.ObjetosMapa.PorVida;

import GameObjects.ObjetosMapa.ObjetoMapa;
import Juego.Punto;
import Visitor.VisitorObjetoMapa;

public class Piedra extends ObjetoMapa {
	
	public Piedra(Punto p){
		super();
		punto = p;
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto = "img/mapa/piedra.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}


}
