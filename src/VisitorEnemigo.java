
public class VisitorEnemigo extends Visitor {
	
	public void visitAliado(Aliado a) {
		// No debe hacer nada		
	}
	
	public void visitEnemigo(Enemigo e) {
		obj.atacar(e);
	}

}
