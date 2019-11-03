package GameObjects.Aliados;

import Visitor.VisitorAliado;

public class Guerrero extends Aliado {
	
	public Guerrero() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Costo
		super(40, 10, 200, 0, 20, 160); 
		visitor = new VisitorAliado(this);
		
		ruta_dibujo_quieto = "img/aliados/guerrero.gif";
		ruta_dibujo_ataque = "img/aliados/guerrero_ataque_sinLoop.gif";
		ruta_dibujo_moviendose = null;
		
		cambiarDibujo(ruta_dibujo_quieto);  // éste método se encuentra en GameObject
	}	
	
}
