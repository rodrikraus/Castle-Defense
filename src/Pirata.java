import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pirata extends Aliado {

	
	public Pirata(Punto punto) {
		ubicacion = punto;
		ancho = 74;
		largo = 56;
		vida = 40;
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/pirata.gif"));
		dibujo = new JLabel(imagen);
		dibujo.setBounds(ubicacion.getX(), ubicacion.getY(), ancho, largo);
		rango = 3;
		danio = 20;
		costo = 160;			
		v = new VisitorAliado(this);
	}	
	
	@Override
	public void morir() {
		dibujo.setVisible(false); // no se si ésto funca
	}

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(obj.getVida()-5);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
	} 
		if(obj.getVida()<=0)
			obj.getDibujo().setVisible(false); 
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado != null) {
			accept(objIntersectado.getVisitor());
		}
	}	
}
