import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Juego {
	
	protected GUI gui;
	protected Oleada oleada;
	protected Movimiento movimiento;
	
	public Juego(){
		gui = new GUI();
		gui.setVisible(true);
		oleada = new Oleada();
		generarOleada();
		movimiento = new Movimiento(this);
		movimiento.run();		
	}
	
	public void generarOleada(){		
		Enemigo[] enemigos = oleada.oleada1();
		gui.agregarDibujo(enemigos[0]);		
	}	
	
	public void mover() {
		Enemigo[] enemigos = oleada.getArreglo();
		for(int i=0; i<enemigos.length; i++)
			enemigos[i].mover();
	}	
}

