	
public class VisitorAliado extends Visitor {
	
	//usada por aliados
	
	public void visitAliado(Aliado a) {
		// No debe hacer nada
	}
	
	public void visitEnemigo(Enemigo e) {
		
		obj.atacar(e);
	}

}
