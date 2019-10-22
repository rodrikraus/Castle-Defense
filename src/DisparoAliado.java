import java.awt.Rectangle;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int danio, Punto p) {
		super(danio, p);
		v = new VisitorDisparoAliado(this);
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 
	
	@Override
	public void interactuar() {		
		Rectangle pos = dibujo.getBounds();
		int newX = (int) pos.getX()+5;
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();	

		GameObject objIntersectado = mapa.intersectaObjeto(this);
			dibujo.setBounds(newX, newY, ancho, alto); // se mueve
			
		//	System.out.println("disparo se mueve");
		
		
			//this.accept(objIntersectado.getVisitor()); // lo visitan

		//	System.out.println("Disparo Aliado accept - obj intersecado: "+objIntersectado.getClass().toString());

			if(objIntersectado != null) 
				objIntersectado.accept(v);
		
	}
	
}
