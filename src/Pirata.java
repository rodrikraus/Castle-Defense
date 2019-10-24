import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pirata extends Aliado {

	protected int cantDisparos;
	ImageIcon imagen;

	protected int velocidad_de_movimiento;
	protected int velocidad_de_disparo;
	
	public Pirata() {
		punto = null;
		ancho = 74;
		largo = 56;
		vida = 40;
		danio = 10;
		velocidad_de_movimiento = 0;
		velocidad_de_disparo = 20;
		rango = 200;
		costo = 160;			
		imagen = new ImageIcon(this.getClass().getResource("aliados/pirata.gif"));
		dibujo = new JLabel(imagen);
		v = new VisitorAliado(this);
		cantDisparos = 0;
	}	

	@Override
	public void atacar(GameObject obj) {
		//System.out.println("pirata.atacar()");
		
		if(vida>0) {  // si estoy vivo, ataco
		//	obj.setVida(obj.getVida()-danio);
		
			if(cantDisparos%velocidad_de_disparo == 0)
				disparar();
			cantDisparos++;
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		} 
		else
			morir();
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			//System.out.println(objIntersectado.getClass().toString());
			//System.out.println("intersectar() de Pirata encuentra objeto en su rango: "+objIntersectado.getClass().toString());
			objIntersectado.accept(v);
			
			//accept(objIntersectado.getVisitor());
			//disparar();
		}
		//GameObject obj = mapa.intersectaRango(this);
		//if(obj!=null)
		//	disparar();
	}	
	
	public void disparar() {
		imagen = new ImageIcon(this.getClass().getResource("aliados/pirata_ataque.gif"));
		imagen.getImage().flush();  // el flush() vuelve a iniciar el gif
		dibujo.setIcon(imagen);
		//dibujo.repaint();
		
		
		Disparo disparo = new DisparoAliado(danio, new Punto(punto.getX()+80,punto.getY()+20));
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);
		//System.out.println("pirata.disparar()\n\n");
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
}
