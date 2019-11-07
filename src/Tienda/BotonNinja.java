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
		String txt= "<html><body>Ninja<br>$50</body></html>";
		setText(txt);
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Ninja();
		
		return toReturn;
	} 
	
}
