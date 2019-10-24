
public class EstrategiaEnemigoInteractuarAtacar extends EstrategiaEnemigoInteractuar {

	public EstrategiaEnemigoInteractuarAtacar(Enemigo e) {
		super(e);
	}

	@Override
	public void interactuar(GameObject objRecibido) {
		obj.atacar(objRecibido);
	}
}
