	
/*
 * Clase usada por aliados
 */
public class VisitorAliado extends Visitor {
	
	
	protected VisitorAliado(GameObject o) {
		super(o);		
	}

	
	public void visitAliado(Aliado a) { 
		// No debe hacer nada
	}
	
	
	public void visitEnemigo(Enemigo e) { 
		obj.atacar(e); 
	}


	@Override
	public void visitDisparo(Disparo d) {
		
	}
	
	
}
