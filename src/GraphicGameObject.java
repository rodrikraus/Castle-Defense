import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GraphicGameObject {
	
	protected JLabel graphic;
	protected Point pos;
	protected GameObject GO;

	protected Icon mover;
	protected Icon atacar;
	protected Icon morir;
	protected int velocidad;
	
	
	public GraphicGameObject(int veloc, int x, int y) {
		pos = new Point(x, y);
		velocidad = veloc;		
	}
	
	public void mover() {
		int newX = GO.getPunto().x - velocidad;		
		graphic.setBounds(newX, GO.getPunto().y, GO.getPunto().ancho , GO.getPunto().largo);
	}
	
	public void changeGraphic_mover() {
		graphic.setIcon(mover);
	}
	
	public void changeGraphic_atacar() {
		graphic.setIcon(atacar);
	}
	
	public void changeGraphic_morir() {
		graphic.setIcon(morir);
	}
}
