package Visitor;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.ObjetosMapa.ObjetoMapa;
import GameObjects.Premios.Premio;

public class VisitorMuerteInstantanea extends Visitor {

	public VisitorMuerteInstantanea(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		a.morir();

	}

	@Override
	public void visit(Enemigo e) {
		e.morir();
	}

	@Override
	public void visit(DisparoAliado d) {
		d.morir();
	}

	@Override
	public void visit(DisparoEnemigo d) {
		d.morir();
	}

	@Override
	public void visit(Premio p) {
		p.morir();
	}

	@Override
	public void visit(ObjetoMapa OM) {
		OM.morir();
	}

}
