
/*
 * Clase usada por disparos
 */
public class VisitorDisparo extends Visitor {

	protected VisitorDisparo(GameObject o) {
		super(o);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		obj.atacar(e);
	}

	@Override
	public void visitAliado(Aliado a) {
		obj.atacar(a);
	}

	@Override
	public void visitDisparo(Disparo d) {
		// no debe hacer nada ????
	}

}
