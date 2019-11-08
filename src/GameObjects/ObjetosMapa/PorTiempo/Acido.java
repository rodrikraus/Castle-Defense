package GameObjects.ObjetosMapa.PorTiempo;

import GameObjects.ObjetosMapa.ObjetoMapa;
import Visitor.VisitorObjetoMapa;

public class Acido extends ObjetoMapa {
	
	public Acido(){
		super();
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto =  "img/mapa/acido.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}
}
