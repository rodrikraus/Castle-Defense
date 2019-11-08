package GameObjects.Premios;

import GameObjects.GameObject;
import Visitor.Visitor;

public abstract class Premio extends GameObject {

	public Premio() {
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

	public void toClick() {};

}
