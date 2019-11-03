package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Ninja;
import Juego.Mapa;

public class BotonNinja extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonNinja(Tienda t, Mapa m) {
		super(t, m);
		setText("Ninja");
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Ninja();
		
		return toReturn;
	} 
	
}
