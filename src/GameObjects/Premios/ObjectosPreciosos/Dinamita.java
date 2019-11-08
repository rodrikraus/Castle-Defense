package GameObjects.Premios.ObjectosPreciosos;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Visitor.VisitorPremio;

public class Dinamita extends Premio {


	public Dinamita(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/tnt.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);

	}
}
