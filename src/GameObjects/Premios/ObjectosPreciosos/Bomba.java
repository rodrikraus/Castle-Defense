package GameObjects.Premios.ObjectosPreciosos;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Visitor.VisitorPremio;

public class Bomba extends Premio {

	public Bomba(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/bomba.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}

	@Override
	public int toClick() {
		
		return -1;
	}
	
}
