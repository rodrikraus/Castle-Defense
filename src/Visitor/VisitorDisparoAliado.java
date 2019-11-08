package Visitor;
import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.ObjetosMapa.ObjetoMapa;
import GameObjects.Premios.Premio;

/*
 * Clase usada por disparos aliados
 */
public class VisitorDisparoAliado extends Visitor {

	
	public VisitorDisparoAliado(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(Aliado)");
	}

	@Override
	public void visit(Enemigo e) {
		obj.atacar(e);
		
//		System.out.println("VisitorDisparoAliado.visit(Enemigo)");
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(DisparoAliado)");
	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(DisparoEnemigo)");
	}
	
	@Override
	public void visit(Premio p) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ObjetoMapa OM) {
		// TODO Auto-generated method stub
		
	}
}
