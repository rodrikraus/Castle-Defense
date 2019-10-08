import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class BotonFactory extends JButton {
	protected Tienda t;
	
	protected BotonFactory() {
		//Entrada e= crear();
		//t.setToAdd(e);
	}

	
	public abstract void agregarBotones() ;
		/*				
		JButton btn_salir = new JButton("X"); 
		btn_salir.setBounds(711, 0, 45, 30);
		btn_salir.setFont(new Font("Dialog", Font.BOLD, 14));
		btn_salir.setFocusPainted(false);
		btn_salir.setContentAreaFilled(false);
		btn_salir.setBorderPainted(false);
		btn_salir.setOpaque(false);
		panelFondo.add(btn_salir);
		
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		*/
}
