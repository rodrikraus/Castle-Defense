
public class EstrategiaEnemigoInteractuarMover extends EstrategiaEnemigoInteractuar {

	public EstrategiaEnemigoInteractuarMover(Enemigo e) {
		super(e);
	}

	@Override
	public void interactuar(GameObject objRecibido) {
		obj.mover();
	}
}
