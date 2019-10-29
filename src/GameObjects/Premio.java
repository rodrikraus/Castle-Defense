package GameObjects;

import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPremio;;

public abstract class Premio extends GameObject {

	public Premio(int vida, int danio, int rango, int velMov) {
		super(1, 0, 0, 0);

//		Punto punto = new Punto(x,y);
//		Enemigo enemigo = new Perro();
//		enemigo.setPunto(punto);
//		enemigo.setMapa(this);
		
	}

	@Override
	public void accept(Visitor v) {
			v.visit(this);
	}

	@Override
	public void interactuar() {
		// TODO Auto-generated method stub

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

}
