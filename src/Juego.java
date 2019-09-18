
public class Juego {
	
	protected Oleada o1;
	
	public Juego(){
		
		GUI frame = new GUI();
		frame.setVisible(true);
		o1 = new Oleada(frame);
	}
	
	
}
