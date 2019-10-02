	
public class VisitorAliado extends Visitor {
	
	public void visitAliado(Aliado a) {
		obj.atacar(a);
	}
	
	public void visitEnemigo(Enemigo e) {
		// No debe hacer nada
	}

}
