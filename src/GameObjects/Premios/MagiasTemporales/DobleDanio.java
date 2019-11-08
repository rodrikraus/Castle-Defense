package GameObjects.Premios.MagiasTemporales;


import GameObjects.Premios.Premio;
import Juego.Punto;
import Visitor.VisitorPremio;

public class DobleDanio extends Premio {

	public DobleDanio(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/powerupDobleDanio.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);

	}
	

}