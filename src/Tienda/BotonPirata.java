package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Pirata;
import Juego.Mapa;

public class BotonPirata extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonPirata(Tienda t, Mapa m) {
		super(t, m);
		String txt= "<html><body>Pirata<br>$20</body></html>";
		setText(txt);
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Pirata();
		
		return toReturn;
	} 
	
}
