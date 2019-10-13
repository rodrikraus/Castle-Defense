
/*
 * Clase usada por enemigos
 */
public class VisitorEnemigo extends Visitor {
	
	
	protected VisitorEnemigo(GameObject obj) {
		super(obj);
	}
	

	public void visitAliado(Aliado a) {
		obj.atacar(a);	
	}
	
	
	public void visitEnemigo(Enemigo e) {
		// No debe hacer nada		
	}


	@Override
	public void visitDisparo(Disparo d) {
		// TODO Auto-generated method stub
		
	}


}
