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
				
				// Deshabilito todos los botones
				tienda.estadoBotones(false);	
				
				// Creo el aliado
				Aliado aliado = crearAliado();
				
				// Lo guardo en la tienda para que pueda ser agregado
				tienda.setToAdd(aliado);
				
			}
		});
	}
	
	public abstract Aliado crearAliado();

	public int getCosto() {
		return costo;
	}
}
