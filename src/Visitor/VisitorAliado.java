package Visitor;
import javax.swing.ImageIcon;

import Disparos.DisparoAliado;
import Disparos.DisparoEnemigo;
import GameObjects.Aliado;
import GameObjects.Enemigo;
import GameObjects.GameObject;

/*
 * Clase usada por aliados
 */
public class VisitorAliado extends Visitor {

	public VisitorAliado(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Aliado a) {
		// No debe hacer nada	
		//System.out.println("VisitorAliado.visit(Aliado)");
	}

	@Override
	public void visit(Enemigo e) {
		obj.atacar(e);
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada		
	//	System.out.println("VisitorAliado.visit(DisparoAliado)");
	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada	
		//System.out.println("VisitorAliado.visit(DisparoEnemigo)");	
	}
	
}
