import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pirata extends Aliado {

	int cantDisparos;
	
	public Pirata() {
		punto = null;
		ancho = 74;
		largo = 56;
		vida = 40;
		danio = 10;
		rango = 200;
		costo = 160;			
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/pirata.gif"));
		dibujo = new JLabel(imagen);
		v = new VisitorAliado(this);
		cantDisparos = 0;
	}	

	@Override
	public void atacar(GameObject obj) {
		System.out.println("ataca pirata");
		if(vida>0) {  // si estoy vivo, ataco
		//	obj.setVida(obj.getVida()-danio);
		
			if(cantDisparos==0)
				disparar();
			cantDisparos++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
			morir();
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			System.out.println(objIntersectado.getClass().toString());
			objIntersectado.accept(v);
			//accept(objIntersectado.getVisitor());
			//disparar();
		}
		//GameObject obj = mapa.intersectaRango(this);
		//if(obj!=null)
		//	disparar();
	}	
	
	public void disparar() {
		Disparo disparo = new DisparoAliado(danio, new Punto(punto.getX()+80,punto.getY()+20));
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);
		System.out.println("disparó\n\n");
	}
}
