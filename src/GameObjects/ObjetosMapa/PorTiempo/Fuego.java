package GameObjects.ObjetosMapa.PorTiempo;

import GameObjects.ObjetosMapa.ObjetoMapaTemporal;
import Visitor.VisitorMuerteInstantanea;

public class Fuego extends ObjetoMapaTemporal {
	
	public Fuego(){
		super();
		visitor = new VisitorMuerteInstantanea(this);
		
		ruta_dibujo_quieto =  "img/mapa/fuego.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}
}
