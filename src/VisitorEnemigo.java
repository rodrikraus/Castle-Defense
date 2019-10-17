
/*
 * Clase usada por enemigos
 */
public class VisitorEnemigo extends Visitor {

	protected VisitorEnemigo(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		obj.atacar(a);
		//a.atacar(obj);
	}

	@Override
	public void visit(Enemigo e) {
		// No debe hacer nada		
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
