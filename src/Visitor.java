
public abstract class Visitor {
	
	protected GameObject obj;
	
	
	protected Visitor(GameObject o) {
		obj = o;		
	}

	
	public abstract void visit(Aliado a);
	
	public abstract void visit(Enemigo e);
	
	public abstract void visit(DisparoAliado d);
	
	public abstract void visit(DisparoEnemigo d);
	
	
}
