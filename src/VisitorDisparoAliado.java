
/*
 * Clase usada por disparos aliados
 */
public class VisitorDisparoAliado extends Visitor {

	
	protected VisitorDisparoAliado(GameObject o) {
		super(o);
	}

	@Override
	public void visitAliado(Aliado a) {
		// No debe hacer nada
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		obj.atacar(e);
	}

	@Override
	public void visitDisparoAliado(DisparoAliado d) {
		// No debe hacer nada
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo d) {
		// No debe hacer nada
	}

}
