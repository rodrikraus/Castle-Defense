package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Maga;
import Juego.Mapa;

public class BotonMaga extends BotonFactory{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonMaga(Tienda t, Mapa m) {
		super(t, m);
		
		Aliado aliado = new Maga();
		costo = aliado.getCosto();
		
		String txt = "<html><body>Maga<br>$"+costo+"</body></html>";
		setText(txt);
	}

	@Override
	public Aliado crearAliado() {
		return new Maga();
	} 
	
}
