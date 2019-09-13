import java.awt.Rectangle;

public class Punto extends Rectangle {

	private static final long serialVersionUID = 1L;
	protected double x;
	protected double y;
		
		
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
