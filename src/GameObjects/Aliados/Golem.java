package GameObjects.Aliados;

import Visitor.VisitorAliado;

public class Golem extends Aliado {
	
	public Golem() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Costo
		super(40, 10, 200, 0, 20, 160); 
		visitor = new VisitorAliado(this);
		
		ruta_dibujo_quieto = "img/aliados/golem.gif";
		ruta_dibujo_ataque = "img/aliados/golem_ataque_sinLoop.gif";
		ruta_dibujo_moviendose = null;
		
		cambiarDibujo(ruta_dibujo_quieto);  // éste método se encuentra en GameObject
	}	
	
}
