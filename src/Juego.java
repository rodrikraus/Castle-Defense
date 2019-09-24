
public class Juego {
	
	protected GUI g;
	protected Oleada o;
	
	public Juego(){
		g= new GUI();
		g.setVisible(true);
		o= new Oleada();
		generarOleada();
	}
	
	public void generarOleada(){
		
		Enemigo[] lista=o.oleada1();
		g.agregarDibujo(lista[0]);
		
	}
	
	
}
