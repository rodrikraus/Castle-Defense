package Visitor;

import Disparos.DisparoAliado;
import Disparos.DisparoEnemigo;
import GameObjects.Aliado;
import GameObjects.Enemigo;
import GameObjects.GameObject;
import GameObjects.Premio;;

public class VisitorPremio extends Visitor {

	public VisitorPremio(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoEnemigo d) {
		
	}
	
	@Override
	public void visit(Premio p) {
		// TODO Auto-generated method stub
	}
}