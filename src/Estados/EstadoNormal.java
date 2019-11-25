package Estados;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoAliado;
import Juego.Punto;

public class EstadoNormal extends Estado {

	public EstadoNormal(GameObject go) {
		miEntidad = go;
	}
	
	@Override
	public void disparar(int danio, Punto p, int rango) {
		Disparo disparo = new DisparoAliado(danio, p, rango);
		miEntidad.getMapa().add(disparo);
		disparo.setMapa(miEntidad.getMapa());
		
	}

	@Override
	public void sumarMonedas() {
		miEntidad.getMapa().getJuego().getTienda().sumarMonedas(miEntidad.getMonedas());	
	}

}
