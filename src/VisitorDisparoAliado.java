
/*
 * Clase usada por disparos aliados
 */
public class VisitorDisparoAliado extends Visitor {

	
	protected VisitorDisparoAliado(GameObject o) {
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
