
public abstract class Visitor {
	
	protected GameObject obj;
	
	
	public abstract void visitEnemigo(Enemigo e);
	
	public abstract void visitAliado(Aliado a);
	 /*
	public GameObject getObj(){
		return obj;
	}
	
	public void setObj(GameObject obj) {
		this.obj = obj;
	}
	*/
}
