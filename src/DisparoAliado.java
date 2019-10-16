import java.awt.Rectangle;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int danio, Punto p) {
		super(danio, p);
		v = new VisitorDisparoAliado(this);
	}

	@Override
	public void accept(Visitor v){
		v.visitDisparoAliado(this);  
	} 
	
	@Override
	public void interactuar() {		
		Rectangle pos = dibujo.getBounds();
		int newX = (int) pos.getX()+1;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	

		GameObject objIntersectado = mapa.intersectaObjeto(this);
		if(objIntersectado == null)
			dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		else 
			this.accept(objIntersectado.getVisitor()); // lo visitan
	}
}
