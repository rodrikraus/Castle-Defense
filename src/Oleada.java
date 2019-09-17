
public class Oleada {
	
	protected GUI gg;
	Oleada(GUI g){
		Punto punto=new Punto(60,60);
		GameObject p1= new Perro(punto);
		gg=g;
		g.agregarDibujoo(p1.getDibujo());
	}

}
