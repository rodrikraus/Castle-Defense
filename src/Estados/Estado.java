package Estados;

import GameObjects.GameObject;
import Juego.Punto;

public abstract class Estado {
	protected GameObject miEntidad;
	public abstract void disparar(int danio, Punto p, int rango);
	public abstract void sumarMonedas();
	
}
