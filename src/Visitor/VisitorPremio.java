package Visitor;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.ObjetosMapa.ObjetoMapaTemporal;
import GameObjects.ObjetosMapa.ObjetoMapaVida;
import GameObjects.Premios.Premio;;

public class VisitorPremio extends Visitor {

	public VisitorPremio(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		
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

	@Override
	public void visit(ObjetoMapaTemporal OM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObjetoMapaVida OM) {
		// TODO Auto-generated method stub
		
	}
}