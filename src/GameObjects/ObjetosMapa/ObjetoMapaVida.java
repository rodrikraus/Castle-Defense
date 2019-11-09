package GameObjects.ObjetosMapa;

import GameObjects.GameObject;
import Visitor.Visitor;

public class ObjetoMapaVida extends GameObject {

	public ObjetoMapaVida(int vida) {
		// vida, daño, rango, velocidad de Movimiento
		super(vida, 0, 0, 0);

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
	
	public void setDobleDanio(boolean b) {
		//no hace nada
	}
	public void setDobleOro(boolean b) {
		//no hace nada
	}
	

}


