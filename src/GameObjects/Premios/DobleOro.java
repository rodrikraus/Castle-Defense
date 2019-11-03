package GameObjects.Premios;

import javax.swing.JButton;

import Juego.Punto;
import Visitor.VisitorPremio;

public class DobleOro extends Premio {

	public DobleOro(Punto p) {
		super(1, 0, 0, 0);
		punto = p;
		visitor = new VisitorPremio(this);

		ruta_dibujo_quieto = "img/mapa/powerupDobleOro.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);

	}

}
