package Estados;

import GameObjects.GameObject;
import Juego.Punto;

public class EstadoDobleOro extends Estado {
	
	public EstadoDobleOro(GameObject go) {
		miEntidad = go;
	}
	
	@Override
	public void disparar(int danio, Punto p, int rango) {
		//no hace nada ya que los aliados jamas estaran en este estado
		
	}

	@Override
	public void sumarMonedas() {
		miEntidad.getMapa().getJuego().getTienda().sumarMonedas(miEntidad.getMonedas()*2);
	}

}
