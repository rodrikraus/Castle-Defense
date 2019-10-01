
public class VisitorEnemigo extends Visitor {
	
	public visitAliado(Aliado a) {}
	
	public visitEnemigo(Enemigo e) {
		this.miEntidad.atacar(e);
	}

}
