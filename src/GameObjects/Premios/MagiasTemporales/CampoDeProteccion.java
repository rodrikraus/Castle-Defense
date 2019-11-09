package GameObjects.Premios.MagiasTemporales;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Visitor.VisitorPremio;

public class CampoDeProteccion extends Premio {
	
	public CampoDeProteccion(Punto p){
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/burbuja.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
	}

	@Override
	protected boolean getExplotado() {
		// TODO Auto-generated method stub
		return false;
	}

}
