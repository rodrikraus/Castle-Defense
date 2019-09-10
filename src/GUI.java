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

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel dibujo, fondo, dibujo2;
	private int velocidad = 0;
	
	public GUI() {
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.agregarDibujo();
		this.agregarDibujo2();
		this.agregarFondo();
		this.agregarMusicaDeFondo("/sound/musica_de_fondo.wav");
		
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
	
	private void agregarDibujo() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/perro.gif"));
		dibujo = new JLabel(imagen);
		dibujo.setBounds(544, 150, 62, 38);
		this.add(dibujo);
	}
	private void agregarDibujo2() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/perro.gif"));
		dibujo2 = new JLabel(imagen);
		dibujo2.setBounds(544, 200, 62, 38);
		this.add(dibujo2);
	}
	
	private void agregarFondo() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/fondo.png"));
		fondo = new JLabel(imagen);
		fondo.setBounds(1, 1, 544, 349);
		this.add(fondo);
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