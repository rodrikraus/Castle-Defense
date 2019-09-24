
public class Movimiento extends Thread {

	
	private Juego juego;
	
	public Movimiento(Juego j) {
		juego = j;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
}
