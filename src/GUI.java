import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel dibujo, fondo;
	
	public GUI() {
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.agregarDibujo();
		this.agregarFondo();
	}
	
	public void moverse() {
		
		while(true) {
			Rectangle pos = dibujo.getBounds();
			
			int newX = (int) pos.getX() - 1;
			int newY = (int) pos.getY();
			int ancho = (int) pos.getWidth();
			int alto = (int) pos.getHeight();
			
			dibujo.setBounds(newX, newY, ancho, alto);
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
	}
	
	private void agregarDibujo() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/perro.gif"));
		dibujo = new JLabel(imagen);
		dibujo.setBounds(544, 150, 62, 38);
		this.add(dibujo);
	}
	
	private void agregarFondo() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/fondo.png"));
		fondo = new JLabel(imagen);
		fondo.setBounds(1, 1, 544, 349);
		this.add(fondo);
	}
}