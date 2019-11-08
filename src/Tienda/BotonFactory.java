package Tienda;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GameObjects.Aliados.Aliado;
import Juego.Mapa;

public abstract class BotonFactory extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tienda tienda;
	protected Mapa mapa;
	protected int costo;
	
	protected BotonFactory(Tienda t, Mapa m) {
		super();
		tienda = t;
		mapa = m;
		setFont(new Font("Dialog", Font.LAYOUT_LEFT_TO_RIGHT, 10));
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tienda.estadoBotones(false);				
				Aliado aliado = crearAliado();
				
				tienda.setNewMonedas(tienda.getMonedas() - aliado.getCosto());
				if(tienda.getNewMonedas() > 0) {
					tienda.setToAdd(aliado);
				}
				else {
					aliado = null;
					tienda.estadoBotones(true);				}
				
				
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

	public int getCosto() {
		return costo;
	}
}
