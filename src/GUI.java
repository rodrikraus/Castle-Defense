import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GUI {

	private JFrame frame;
	private JLabel dibujo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setBackground(new Color(205, 133, 63));
		frame.setBounds(100, 100, 724, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		agregarDibujo();	
	}	

	private void agregarDibujo(){
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/img/probando.png"));
		dibujo = new JLabel(imagen);		
		dibujo.setBounds(643, 41, 43, 35);		
		frame.getContentPane().add(dibujo);
	}
	

	protected void mover(){
		// aca va el algoritmo para mover el objeto
	}
}
