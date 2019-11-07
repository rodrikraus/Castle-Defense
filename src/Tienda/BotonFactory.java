package Tienda;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GameObjects.Aliados.Aliado;
import Juego.Mapa;

public abstract class BotonFactory extends JButton {
	protected Tienda tienda;
	protected Mapa mapa;
	
	protected BotonFactory(Tienda t, Mapa m) {
		super();
		tienda = t;
		mapa = m;
		setFont(new Font("Dialog", Font.LAYOUT_LEFT_TO_RIGHT, 10));
		//Entrada e= crear();
		//t.setToAdd(e);
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aliado aliado = crearAliado();
				//tienda.setToAdd(aliado);
				
				if(tienda.monedas-aliado.getCosto()>0) {
					//Aliado aliado = crearAliado();
					tienda.setToAdd(aliado);
					tienda.setMonedas(tienda.monedas-aliado.getCosto());
				}
				
				
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
