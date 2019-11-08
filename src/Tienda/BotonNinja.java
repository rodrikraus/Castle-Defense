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
		
		Aliado aliado = new Ninja();
		costo = aliado.getCosto();
		
		String txt = "<html><body>Ninja<br>$"+costo+"</body></html>";
		setText(txt);
	}

	@Override
	public Aliado crearAliado() {
		return new Ninja();
	} 
	
}
