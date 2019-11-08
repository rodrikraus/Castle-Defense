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
		
		Aliado aliado = new Golem();
		costo = aliado.getCosto();
		
		String txt = "<html><body>Golem<br>$"+costo+"</body></html>";
		setText(txt);
	}

	@Override
	public Aliado crearAliado() {
		return new Golem();
	} 
	

}
