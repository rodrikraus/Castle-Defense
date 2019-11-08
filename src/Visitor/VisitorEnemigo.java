package Visitor;
import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.ObjetosMapa.ObjetoMapa;
import GameObjects.Premios.Premio;

/*
 * Clase usada por enemigos
 */
public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		obj.atacar(a);
//		System.out.println("VisitorEnemigo.visit(Aliado)");
		
	}

	@Override
	public void visit(Enemigo e) {
		obj.mover();
//		System.out.println("VisitorEnemigo.visit(Enemigo)");	
	}

	@Override
	public void visit(DisparoAliado d) {
//		No debe hacer nada		
		obj.mover();
//		System.out.println("VisitorEnemigo.visit(DisparoAliado)");
	}

	@Override
	public void visit(DisparoEnemigo d) {
//		No debe hacer nada
		obj.mover();
//		System.out.println("VisitorEnemigo.visit(DisparoEnemigo)");
	}
	
	@Override
	public void visit(Premio p) {
		obj.atacar(p);
	}

	@Override
	public void visit(ObjetoMapa OM) {
		// TODO Auto-generated method stub
		
	}
}
