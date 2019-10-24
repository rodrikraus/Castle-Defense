
public abstract class EstrategiaEnemigoInteractuar {

	protected Enemigo obj;
	
	public EstrategiaEnemigoInteractuar(Enemigo e) {
		obj = e;
	}
	
	public abstract void interactuar(GameObject objRecibido);
	
}
