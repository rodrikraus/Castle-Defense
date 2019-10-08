
public abstract class Visitor {
	
	protected GameObject obj;
	
	protected Visitor(GameObject o) {
		this.obj=o;		
	}
	
	public abstract void visitEnemigo(Enemigo e);
	
	public abstract void visitAliado(Aliado a);
	
}
