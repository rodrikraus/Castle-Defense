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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Aliado a) {
		obj.atacar(a);

	}

	@Override
	public void visit(Enemigo e) {
		obj.atacar(e);
	}

	@Override
	public void visit(DisparoAliado d) {
		obj.atacar(d);
		}

	@Override
	public void visit(DisparoEnemigo d) {
		obj.atacar(d);

	}

	@Override
	public void visit(Premio p) {
		obj.atacar(p);

	}

	@Override
	public void visit(ObjetoMapa OM) {
		obj.atacar(OM);
	}

}
