package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Golem;
import Juego.Mapa;

public class BotonGolem extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonGolem(Tienda t, Mapa m) {
		super(t, m);
		String txt= "<html><body>Golem<br>$160</body></html>";
		setText(txt);
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Golem();
		
		return toReturn;
	} 
	
}
