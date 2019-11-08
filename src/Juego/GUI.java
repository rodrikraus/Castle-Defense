package Juego;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameObjects.GameObject;
import Tienda.Tienda;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

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
	private JLabel fondo;
	private JLabel lblTienda; 
	private JLabel lblMonedas;
	private JLabel lblValorMonedas;
	private JLabel lblOleada;
    private Point initialClick;
    private Tienda tienda;
    private Mapa mapa;
    private JButton botonVender;

	private Punto punto = null; // punto para saber coordenada de insertar aliado de tienda
    
	public GUI(Tienda t) {
		tienda = t;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 580);
		setUndecorated(true);
		panelFondo = new JPanel();
		panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelFondo);
		panelFondo.setLayout(null);
		crearLabelOleada();
		crearPanelCesped();
		this.agregarBotonesGenerales();
		this.agregarFondo();
		agregarBotonesTienda(tienda.getListaBotones());
		//this.agregarMusicaDeFondo("/sound/musica_de_fondo.wav");  no se puede .wav
		

	}
	
	public void setMapa(Mapa m) {
		mapa = m;
	}
	
	public void agregarBotonesTienda(List<JButton> lista) {
		int x = 5;
		int y = 30;
		int ancho = 90;
		int largo = 60;
		
		for(JButton boton : lista) {
			boton.setBounds(x, y, ancho, largo);
			panelTienda.add(boton);
			x = x + ancho + 10;
		}
		
		botonVender = new JButton();
		botonVender.setFont(new Font("Dialog", Font.LAYOUT_LEFT_TO_RIGHT, 10));
		botonVender.setText("Vender Aliado");
		botonVender.setBounds(x, y, ancho+30, largo);
		panelTienda.add(botonVender);
		x = x + ancho + 10;
		
		botonVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// se activa el modo vender
				
				tienda.estadoBotones(false);
				botonVender.setEnabled(false);
				tienda.setPuedoVender(true);
				
			}
		});
		
		
		
	}
	
	public Rectangle getRectanglePanelCesped() {
		return panelCesped.getBounds();
	}
	
	public void crearPanelCesped() {
		panelCesped = new JPanel();
		panelCesped.setLayout(null);
		panelCesped.setBounds(67, 215, 686, 265);
		panelCesped.setBackground(Color.RED);
		panelCesped.setOpaque(false);
		panelFondo.add(panelCesped);
		
		panelCesped.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}			
			public void mousePressed(MouseEvent e) {}			
			public void mouseExited(MouseEvent e) {}			
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getPoint().x - 30;
				int y = e.getPoint().y - 30;
				punto = new Punto(x, y);
				GameObject obj = tienda.getToAdd();
				if(obj!=null) {
					obj.setPunto(punto);
					if(mapa.puedoAgregarObjeto(obj)) {
						mapa.add(obj);
						obj.setMapa(mapa);
						tienda.restarMonedas(obj.getCosto());
					}
					tienda.setToAdd(null);
				}
				
				if(tienda.getPuedoVender()){
					GameObject objClickeado = mapa.intersectaClickConGameObject(punto);
					if(objClickeado!=null) {
						System.out.println("click en objeto");
						int aliadoVendido = objClickeado.toClick();
						tienda.sumarMonedas(aliadoVendido);
						tienda.setPuedoVender(false);
					}
					
				}
				botonVender.setEnabled(true);
				tienda.estadoBotones(true);
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
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/mapa/fondo_grande.gif"));
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
				lblTienda.setBounds(10, 5, 54, 17);
				lblTienda.setFont(new Font("Dialog", Font.BOLD, 14));
				panelTienda.add(lblTienda);
				
				lblMonedas = new JLabel("Monedas  $");
				//lblMonedas.setBounds(680, 5, 65, 17);
				lblMonedas.setBounds(570, 5, 91, 17);
				lblMonedas.setFont(new Font("Dialog", Font.BOLD, 14));
				panelTienda.add(lblMonedas);
				
				//label actualizable
				lblValorMonedas = new JLabel(""+tienda.getMonedas());
//				lblValorMonedas.setBounds(700, 20, 65, 17);
				lblValorMonedas.setBounds(670, 5, 60, 17);
				lblValorMonedas.setFont(new Font("Dialog", Font.BOLD, 14));
				panelTienda.add(lblValorMonedas);
			}
		}
	}
	
	public void gameOver(){
		
		// Borramos todo del panel
        panelFondo.removeAll();
  
        // Cargamos la imagen del GameOver
  		ImageIcon img_gameOver = new ImageIcon(getClass().getClassLoader().getResource("img/gui/gameover.png"));
		JLabel lbl_gameOver = new JLabel(img_gameOver);	
		
		// Obtengo el ancho y el alto de la nueva imagen
		int ancho = img_gameOver.getIconWidth();
		int largo = img_gameOver.getIconHeight();
		lbl_gameOver.setBounds(0, 0, ancho, largo);
		
		// Establezco el tamaño de la ventana al tamaño de la imagen
		this.setSize(ancho, largo);
		
		// Agrego la imagen al panel
		panelFondo.add(lbl_gameOver);
		
		// Refresco el panel
		panelFondo.repaint();		
		
		
		// Esperamos unos segundos para cerrar el juego...
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Cerramos el juego
		System.exit(0);
		
	}
	
	public void actualizarMonedas() {
		lblValorMonedas.setText(""+tienda.getMonedas());		
	}
	
public void youWin(){
		
		// Borramos todo del panel
        panelFondo.removeAll();
  
        // Cargamos la imagen del GameOver
  		ImageIcon img_youWin = new ImageIcon(getClass().getClassLoader().getResource("img/gui/youwin.png"));
		JLabel lbl_youWin = new JLabel(img_youWin);	
		
		// Obtengo el ancho y el alto de la nueva imagen
		int ancho = img_youWin.getIconWidth();
		int largo = img_youWin .getIconHeight();
		lbl_youWin.setBounds(0, 0, ancho, largo);
		
		// Establezco el tamaño de la ventana al tamaño de la imagen
		this.setSize(ancho, largo);
		
		// Agrego la imagen al panel
		panelFondo.add(lbl_youWin);
		
		// Refresco el panel
		panelFondo.repaint();		
		
		
		// Esperamos unos segundos para cerrar el juego...
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Cerramos el juego
		System.exit(0);
		
	}

	public void crearLabelOleada() {
		ImageIcon imgOleada1 = new ImageIcon(getClass().getClassLoader().getResource("img/gui/oleada1.gif"));
		int ancho = imgOleada1.getIconWidth();
		int largo = imgOleada1.getIconHeight();
		lblOleada = new JLabel(imgOleada1);
		lblOleada.setBounds(280, 150, ancho, largo);
		panelFondo.add(lblOleada);
	}
	
	public void mostrarOleada2() {
		lblOleada.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/gui/oleada2.gif")));
	}
	
	public void mostrarOleada3() {
		lblOleada.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/gui/oleada3.gif")));
	}
	
	
	/*
	 * No se puede utilizar sonido .wav
	 * 
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
	*/
}