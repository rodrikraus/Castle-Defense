import javax.swing.JButton;

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
		
		return new Pirata();
	} 
	
}
