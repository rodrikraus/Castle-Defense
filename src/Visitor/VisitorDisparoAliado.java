package Visitor;
import Disparos.DisparoAliado;
import Disparos.DisparoEnemigo;
import GameObjects.Aliado;
import GameObjects.Enemigo;
import GameObjects.GameObject;

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
		System.out.println("VisitorDisparoAliado.visit(Aliado)");
	}

	@Override
	public void visit(Enemigo e) {
		//e.setAgresivo(false);
		obj.atacar(e);
		
		System.out.println("VisitorDisparoAliado.visit(Enemigo)");
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada
		System.out.println("VisitorDisparoAliado.visit(DisparoAliado)");
	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada
		System.out.println("VisitorDisparoAliado.visit(DisparoEnemigo)");
	}

}
