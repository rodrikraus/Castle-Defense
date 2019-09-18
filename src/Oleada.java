
public class Oleada {
	
	protected GUI gg;
	
	Oleada(GUI g){
		
		Punto punto=new Punto(544, 249);
		GameObject p1= new Perro(punto);
		Perro p= new Perro(punto);
		gg=g;
		gg.agregarDibujooo(p);
		
	}

}
