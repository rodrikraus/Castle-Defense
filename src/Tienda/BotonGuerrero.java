package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Guerrero;
import Juego.Mapa;

public class BotonGuerrero extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonGuerrero(Tienda t, Mapa m) {
		super(t, m);

		Aliado aliado = new Guerrero();
		costo = aliado.getCosto();
		
		String txt = "<html><body>Guerrero<br>$"+costo+"</body></html>";
		setText(txt);
	}

	@Override
	public Aliado crearAliado() {
		return new Guerrero();
	} 
	
	
}
