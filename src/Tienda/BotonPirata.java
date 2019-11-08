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
		
		Aliado aliado = new Pirata();
		costo = aliado.getCosto();
		
		String txt = "<html><body>Pirata<br>$"+costo+"</body></html>";
		setText(txt);
	}

	@Override
	public Aliado crearAliado() {
		return new Pirata();
	} 
	
}
