package GameObjects.ObjetosMapa;

import GameObjects.GameObject;
import Visitor.Visitor;

public class ObjetoMapa extends GameObject {

	public ObjetoMapa() {
		// vida, daño, rango, velocidad de Movimiento
		super(1, 0, 0, 0);

	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	
	public boolean interactuar() {
		return true;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atacar(GameObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciarAtaque(GameObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	// Que pasa cuando se le hace click ??
	public int toClick() {
		return 0;
	}
}


