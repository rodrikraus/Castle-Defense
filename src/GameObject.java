import javax.swing.JLabel;

public abstract class GameObject {
	
	protected int vida;
	protected Punto ubicacion;
	protected JLabel dibujo;
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public Punto getPunto() {
		return ubicacion;
	}
	public void setPunto(Punto punto) {
		this.ubicacion = punto;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	public void setDibujo(JLabel dibujo) {
		this.dibujo = dibujo;
	}
	
	

}
