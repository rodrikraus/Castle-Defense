import javax.swing.JLabel;

public abstract class GameObject {
	
	protected int vida;
	protected Punto ubicacion;
	protected JLabel dibujo;
	protected int ancho;
	protected int largo;
	protected Visitor v;
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Punto getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Punto punto) {
		this.ubicacion = punto;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	public void setDibujo(JLabel dibujo) {
		this.dibujo = dibujo;
	}
	public int getAncho() {
		return ancho;
	}
	
	public int getLargo() {
		return largo;
	}	
	
	public abstract void accept(Visitor v);
	
	public abstract void atacar(GameObject obj); // no se si está bien
}
