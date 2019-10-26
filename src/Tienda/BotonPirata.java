package Tienda;
import javax.swing.JButton;

import GameObjects.Aliado;
import GameObjects.Pirata;
import Juego.Mapa;

public class BotonPirata extends BotonFactory{

	
	protected BotonPirata(Tienda t, Mapa m) {
		super(t, m);
		JButton btn_pirata = new JButton("Pirata");
		btn_pirata.setBounds(711, 0, 45, 30);
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Pirata();
		
		return toReturn;
	} 
	
}
