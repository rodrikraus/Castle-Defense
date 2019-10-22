import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelFondo,panelTienda, panelCesped;
	private JLabel fondo; // por que global?
	private JLabel lblTienda; // por que global??
    private Point initialClick;
    private Tienda tienda;

	private Punto punto = null; // punto para saber coordenada de insertar aliado de tienda
    
	public GUI(Tienda t) {		
		tienda = t;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 580);
		setUndecorated(true);
		panelFondo = new JPanel();
		panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelFondo);
		panelFondo.setLayout(null);
		crearPanelCesped();
		this.agregarBotonesGenerales();
		this.agregarFondo();
		this.agregarMusicaDeFondo("/sound/musica_de_fondo.wav");
		

	}
	
	public void crearPanelCesped() {
		panelCesped = new JPanel();
		panelCesped.setLayout(null);
		panelCesped.setBounds(67, 215, 686, 265);
		panelCesped.setBackground(Color.BLACK);
		panelFondo.add(panelCesped);
		
		panelCesped.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}			
			public void mousePressed(MouseEvent e) {}			
			public void mouseExited(MouseEvent e) {}			
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getPoint().x;
				int y = e.getPoint().y;
				punto = new Punto(x, y);
				GameObject obj = tienda.getToAdd();
				if(obj!=null) {
					obj.setPunto(punto);
					panelCesped.add(obj.getDibujo());
					tienda.setToAdd(null);
				}
			}
		});
	}

	public void agregarDibujo(GameObject e) {		
		int x = e.getPunto().getX();
		int y = e.getPunto().getY();
		int ancho = e.getAncho();
		int largo = e.getLargo();
		JLabel dibujo = e.getDibujo();
		dibujo.setBounds(x, y, ancho, largo);
		dibujo.setVisible(true);
		panelCesped.add(dibujo,0);		
		panelCesped.repaint();
	}
		
	private void agregarBotonesGenerales() {
						
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
		JButton btn_mover_frame = new JButton("");
		btn_mover_frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
	            // get location of Window
	            int thisX = getLocation().x;
	            int thisY = getLocation().y;

	            // Determine how much the mouse moved since the initial click
	            int xMoved = e.getX() - initialClick.x;
	            int yMoved = e.getY() - initialClick.y;

	            // Move window to this position
	            int X = thisX + xMoved;
	            int Y = thisY + yMoved;
	            setLocation(X, Y);
			}
		});
		btn_mover_frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btn_mover_frame.setFocusPainted(false);
		btn_mover_frame.setContentAreaFilled(false);
		btn_mover_frame.setBorderPainted(false);
		btn_mover_frame.setOpaque(false);
		btn_mover_frame.setBounds(1, 0, 698, 38);
		panelFondo.add(btn_mover_frame);
			
	}
	
	private void agregarFondo() {
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("mapa/fondo_grande.png"));
		fondo = new JLabel(imagen);
		fondo.setBounds(0, 0, 756, 485);
		panelFondo.add(fondo);
		
		{
			panelTienda = new JPanel();
			panelTienda.setBackground(new Color(218, 165, 32));
			panelTienda.setBounds(0, 485, 756, 95);
			panelFondo.add(panelTienda);
			panelTienda.setLayout(null);
			{
				lblTienda = new JLabel("Tienda");
				lblTienda.setBounds(30, 12, 54, 17);
				lblTienda.setFont(new Font("Dialog", Font.BOLD, 14));
				panelTienda.add(lblTienda);
			}
		}
	}	

	private void agregarMusicaDeFondo(String ruta) {
		try {
			
			BufferedInputStream bis = new BufferedInputStream(this.getClass().getResourceAsStream(ruta));
			AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
			Clip sonido = AudioSystem.getClip();
			sonido.open(ais);			
			sonido.start();		
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}		
	}
}