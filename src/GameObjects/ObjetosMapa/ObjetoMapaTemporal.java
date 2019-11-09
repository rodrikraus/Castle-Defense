package GameObjects.ObjetosMapa;

import GameObjects.GameObject;
import Visitor.Visitor;

public class ObjetoMapaTemporal extends GameObject {
	
	protected int tiempoDeVida;

	public ObjetoMapaTemporal() {
		// vida, daño, rango, velocidad de Movimiento
		super(9999, 0, 0, 0);
		tiempoDeVida = 300;

	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	
	public boolean interactuar() {
		GameObject objChocado = mapa.intersectaObjeto(this);
		if(objChocado != null) {
			objChocado.accept(visitor);
		}
		tiempoDeVida--;
		if(tiempoDeVida < 0)
			morir();
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


