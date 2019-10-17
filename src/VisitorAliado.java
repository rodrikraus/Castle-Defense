	
/*
 * Clase usada por aliados
 */
public class VisitorAliado extends Visitor {

	protected VisitorAliado(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		// No debe hacer nada		
	}

	@Override
	public void visit(Enemigo e) {
		obj.atacar(e);
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada		
	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada		
	}
	
}
