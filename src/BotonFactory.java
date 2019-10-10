import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class BotonFactory extends JButton {
	protected Tienda tienda;
	protected Mapa mapa;
	
	protected BotonFactory(Tienda t, Mapa m) {
		tienda = t;
		mapa = m;
		//Entrada e= crear();
		//t.setToAdd(e);
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aliado aliado = crearAliado();
				tienda.setToAdd(aliado);
				
	//			Punto punto = tienda.getJuego().getGUI().activarOyentePanelCesped();
	//			aliado.setUbicacion(punto);
				
	//			tienda.getJuego().getGUI().agregarDibujo(aliado);
	//			mapa.getListaPrincipal().add(aliado);
	//			aliado.setMapa(mapa);
				// obtener posicion en la que se va a agregar
				// llamar oyente de GUI para capturar posicion de click
			}
		});
	}
	
	
	public abstract Aliado crearAliado();

	
		
}
