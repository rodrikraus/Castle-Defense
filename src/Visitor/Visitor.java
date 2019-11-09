package Visitor;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.ObjetosMapa.ObjetoMapa;
import GameObjects.Premios.Premio;

public abstract class Visitor {
	
	protected GameObject obj;
	
	
	public Visitor(GameObject o) {
		obj = o;		
	}

	
	public abstract void visit(Aliado a);
	
	public abstract void visit(Enemigo e);
	
	public abstract void visit(DisparoAliado d);
	
	public abstract void visit(DisparoEnemigo d);

	public abstract void visit(Premio p);

	public abstract void visit(ObjetoMapa OM);
	
	
}
