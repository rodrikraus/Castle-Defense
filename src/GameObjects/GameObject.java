package GameObjects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public abstract class GameObject {
	
	protected int vida; 
	protected int danio; 
	protected int rango; 
	protected int velocidad_movimiento;
	protected int frecuencia_ataques;
	
	protected int velocidad_ataque;
	protected Mapa mapa;
	
	protected Punto punto; 
	protected JLabel dibujo;

	protected int ancho; 
	protected int largo; 
	protected Visitor visitor;
	
	
	protected String ruta_dibujo_quieto;
	protected String ruta_dibujo_moviendose;
	protected String ruta_dibujo_ataque;
	
	public GameObject(int vida, int danio, int rango, int velMov) {
		this.vida = vida;
		this.danio = danio;
		this.rango = rango;
		this.velocidad_movimiento = velMov;
		frecuencia_ataques = 0;
		punto = null;
		
	}
	
	public void cambiarDibujo(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}
	
	public void flushDibujo(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));
		imagen.getImage().flush();  // el flush() vuelve a iniciar el gif
		dibujo.setIcon(imagen);	
	}

	public abstract void accept(Visitor v);	
	//public abstract void interactuar();
	public abstract boolean interactuar();
	public abstract void mover();
	public abstract void atacar(GameObject obj); 
	public abstract void iniciarAtaque(GameObject obj);

	public void morir() {
		mapa.getListaEliminar().add(this);
	}
	
	
	public int getFrecuencia_ataques() { return frecuencia_ataques ;}
	public void setFrecuencia_ataques(int frecAtaques) { frecuencia_ataques = frecAtaques ;}
	
	public int getDanio() { return danio ;}
	public void setDanio(int danio) { this.danio = danio ;}	

	public int getRango() {	return rango ;}
	public void setRango(int rango) { this.rango = rango ;}
	
	public int getVida() { return vida ;}
	public void setVida(int vida) { this.vida = vida ;}
	
	public Punto getPunto() { return punto ;}
	public void setPunto(Punto p) {punto = p ;}

	public JLabel getDibujo() { return dibujo ;}
	public void setDibujo(JLabel dibujo) { this.dibujo = dibujo ;}

	public int getAncho() {	return ancho ;}
	public int getLargo() {	return largo ;}	
	
	public void setMapa(Mapa mapa) { this.mapa = mapa ;}

	public int getVelocidad_movimiento() { return velocidad_movimiento ;}
	
	public Visitor getVisitor() { return visitor ;}
	
	
}
