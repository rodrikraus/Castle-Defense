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
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelFondo,panelTienda;
	private JLabel dibujo, fondo, dibujo2;
	private JLabel lblTienda;
    private Point initialClick;
    //private Perro p1;
	
	public GUI() {
		
		//panelFondo.setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 580);
		setUndecorated(true);
		panelFondo = new JPanel();
		panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelFondo);
		panelFondo.setLayout(null);
		//this.agregarDibujo();
		//this.agregarDibujo2();
		this.agregarFondo();
		//this.agregarDibujo();
		this.agregarBotonesGenerales();
		this.agregarMusicaDeFondo("/sound/musica_de_fondo.wav");
		//p1 = new Perro(new Punto(544,400));
		//panelFondo.add(p1.getDibujo());		
	}

	public void moverse() {
		
		while(true) {
			
			Rectangle pos = dibujo.getBounds();
			Rectangle pos2 = dibujo2.getBounds();
			
			int newX = (int) pos.getX() - 1;
			int newY = (int) pos.getY();
			int ancho = (int) pos.getWidth();
			int alto = (int) pos.getHeight();	
			
			int newX2 = (int) pos2.getX() - 2;			
			int newY2 = (int) pos2.getY();
			int ancho2 = (int) pos2.getWidth();
			int alto2 = (int) pos2.getHeight();
						
			dibujo.setBounds(newX, newY, ancho, alto);	
			dibujo2.setBounds(newX2, newY2, ancho2, alto2);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Error ");	
			}
		}
	}
	
	public void agregarDibujooo(GameObject e) {
		int x= e.getUbicacion().getX();
		int y= e.getUbicacion().getY();
		int ancho= e.getAncho();
		int largo=e.getLargo();
		JLabel dibujo= e.getDibujo();
		dibujo.setBounds(x, y,ancho, largo);
		dibujo.setVisible(true);
		panelFondo.add(dibujo);		
	}
	
	public void agregarDibujoo(JLabel obj){
		
		obj.setBounds(544, 249, 62, 38);
		obj.setVisible(true);
		panelFondo.add(obj);
				
	}
	
	public void agregarDibujo(){
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
		dibujo = new JLabel(imagen);
		dibujo.setBounds(544, 249, 62, 38);
		panelFondo.add(dibujo);
		/*
		dibujo2 = new JLabel(imagen);
		dibujo2.setBounds(544, 314, 62, 38);
		panelFondo.add(dibujo2);
		*/		
	}
	
	/*
	private void agregarDibujo2() {
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
	
	}*/
	
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