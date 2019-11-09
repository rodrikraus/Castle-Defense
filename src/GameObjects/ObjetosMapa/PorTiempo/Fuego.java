package GameObjects.ObjetosMapa.PorTiempo;

import GameObjects.ObjetosMapa.ObjetoMapa;
import Visitor.VisitorObjetoMapa;

public class Fuego extends ObjetoMapa {
	
	public Fuego(){
		super();
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto =  "img/mapa/fuego.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}
}
