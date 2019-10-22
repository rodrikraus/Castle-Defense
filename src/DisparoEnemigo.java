import java.awt.Rectangle;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int danio, Punto p) {
		super(danio, p);
		v = new VisitorDisparoEnemigo(this);
	}


	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 
	
	@Override
	public void interactuar() {		
		Rectangle pos = dibujo.getBounds();
		int newX = (int) pos.getX()-3;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	

		GameObject objIntersectado = mapa.intersectaObjeto(this);
		
		dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		if(objIntersectado != null) 
			objIntersectado.accept(v);
	}

}
