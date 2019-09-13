import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo{
	
	private final int ancho = 62;
	private final int largo = 38;
	
	public Perro(Punto p) {
		rango = 1;
		daño = 10;
		vida = 30;
//		velocidad = ¿RAPIDA?
		puntos = 35;
		monedas = 30;
		
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("img/perro.gif"));
		dibujo = new JLabel(imagen);
	//	dibujo.setBounds(p.getX(), p.getY(), ancho, largo);
	}
	

	public int getAncho() {
		return ancho;
	}

	public int getLargo() {
		return largo;
	}
	
}
