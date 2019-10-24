import javax.swing.ImageIcon;

/*
 * Clase usada por aliados
 */
public class VisitorAliado extends Visitor {

	protected VisitorAliado(GameObject o) {
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

		/*
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("aliados/pirata.gif"));		
		obj.getDibujo().setIcon(imagen);
		obj.getDibujo().repaint();
		*/
		//e.setAgresivo(true);
		//System.out.println("VisitorAliado.visit(Enemigo)");
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
