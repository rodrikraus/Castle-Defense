package Visitor;
import javax.swing.ImageIcon;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Enemigos.Enemigo;
import GameObjects.Premios.Premio;

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

	@Override
	public void visit(Premio p) {
		// TODO Auto-generated method stub
	}
	
}
