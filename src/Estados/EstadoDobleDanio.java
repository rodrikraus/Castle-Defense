package Estados;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoAliado;
import Juego.Punto;

public class EstadoDobleDanio extends Estado {

	public EstadoDobleDanio(GameObject go) {
		miEntidad = go;
	}
	
	@Override
	public void disparar(int danio, Punto p, int rango) {
		Disparo disparo = new DisparoAliado(danio*2, p, rango);
		disparo.cambiarDibujo("img/disparos/disparo_angosto_potenciado.gif");
		miEntidad.getMapa().add(disparo);
		disparo.setMapa(miEntidad.getMapa());		
	}

	@Override
	public void sumarMonedas() {
		// TODO Auto-generated method stub
		
	}

}
