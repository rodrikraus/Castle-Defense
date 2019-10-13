import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pirata extends Aliado {

	
	public Pirata() {
		punto = null;
		ancho = 74;
		largo = 56;
		vida = 40;
		danio = 10;
		rango = 40;
		costo = 160;			
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/pirata.gif"));
		dibujo = new JLabel(imagen);
		v = new VisitorAliado(this);
	}	

	@Override
	public void atacar(GameObject obj) {
		if(vida>0) {  // si estoy vivo, ataco
			//obj.setVida(obj.getVida()-danio);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
			morir();
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado != null) {
			accept(objIntersectado.getVisitor());
		}
		//GameObject obj = mapa.intersectaRango(this);
		//if(obj!=null)
		//	disparar();
	}	
	
	public void disparar() {
		Disparo disparo = new Disparo(danio, new Punto(punto.getX()+10,punto.getY()));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
