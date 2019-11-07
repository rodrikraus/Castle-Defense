package GameObjects.Aliados;

import Visitor.VisitorAliado;

public class Maga extends Aliado {
	
	public Maga() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Costo
		super(40, 10, 200, 0, 20, 65); 
		visitor = new VisitorAliado(this);
		
		ruta_dibujo_quieto = "img/aliados/maga.gif";
		ruta_dibujo_ataque = "img/aliados/maga_ataque_sinLoop.gif";
		ruta_dibujo_moviendose = null;
		
		cambiarDibujo(ruta_dibujo_quieto);  // éste método se encuentra en GameObject
	}	
	
}
