
public class VisitorEnemigo extends Visitor {
	
	//usada por enemigos
	
	protected VisitorEnemigo(GameObject o) {
		super(o);
	}

	public void visitAliado(Aliado a) {
		obj.atacar(a);	
	}
	
	public void visitEnemigo(Enemigo e) {
		// No debe hacer nada
		
	}

}
