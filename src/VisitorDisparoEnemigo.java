
/*
 *  Clase usada por disparos enemigos
 */
public class VisitorDisparoEnemigo extends Visitor {

	protected VisitorDisparoEnemigo(GameObject o) {
		super(o);
	}

	@Override
	public void visitAliado(Aliado a) {
		obj.atacar(a);		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// No debe hacer nada
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
