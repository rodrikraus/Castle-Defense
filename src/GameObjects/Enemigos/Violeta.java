package GameObjects.Enemigos;

import Visitor.VisitorEnemigo;

public class Violeta extends Enemigo {
		
	public Violeta() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Puntos, Monedas
		super(40, 5, 100, 3, 20, 35, 30); 
		visitor = new VisitorEnemigo(this);
				
		ruta_dibujo_quieto = null;
		ruta_dibujo_moviendose = "img/enemigos/violeta.gif";
		ruta_dibujo_ataque = "img/enemigos/violeta_ataque.gif";

		cambiarDibujo(ruta_dibujo_moviendose);
	}	
	

}
