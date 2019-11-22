package GameObjects.Premios;

import GameObjects.GameObject;
import Visitor.Visitor;

public abstract class Premio extends GameObject {

	protected int tiempo_de_vida;
	
	protected Premio() {
		// vida, daño, rango, velocidad de Movimiento
		super(1, 1000, 0, 0);
		tiempo_de_vida = 25;
		

	}

	@Override
	public void accept(Visitor v) {
			v.visit(this);
	}

	
	public boolean interactuar() {
		
		if(getExplotado()) {
			for(GameObject obj : mapa.todosLosQueIntersecta(this))
				obj.accept(visitor);
			if(tiempo_de_vida-- <0)
				morir();
		}
		return true;
	}

	protected abstract boolean getExplotado();

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atacar(GameObject obj) {
		obj.setVida(-10);
		

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
