
/*
 * Clase usada por enemigos
 */
public class VisitorEnemigo extends Visitor {

	protected VisitorEnemigo(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		obj.setAgresivo(true);
		//obj.atacar(a);
		//a.atacar(obj);
		System.out.println("VisitorEnemigo.visit(Aliado)");
	}

	@Override
	public void visit(Enemigo e) {
		// No debe hacer nada	
		System.out.println("VisitorEnemigo.visit(Enemigo)");	
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada
		obj.setAgresivo(false);
		System.out.println("VisitorEnemigo.visit(DisparoAliado)");
	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada
		System.out.println("VisitorEnemigo.visit(DisparoEnemigo)");
	}
}
