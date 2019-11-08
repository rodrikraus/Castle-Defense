package GameObjects.ObjetosMapa.PorTiempo;

import GameObjects.ObjetosMapa.ObjetoMapa;
import Visitor.VisitorObjetoMapa;

public class RecargaVida extends ObjetoMapa {
	
	public RecargaVida(){
		super();
		visitor = new VisitorObjetoMapa(this);
		
		ruta_dibujo_quieto = null;
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		//cambiarDibujo(ruta_dibujo_quieto);
		
	}
}
