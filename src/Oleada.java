import java.util.Random;

public class Oleada {
	
	Enemigo [] arreglo;
	
	Oleada(){
		arreglo= new Enemigo[1];				
	}

	public Enemigo[] oleada1(){
		
		Random x = new Random();
		int xx= 400+x.nextInt(600 - 400 );
		int yy= 200+x.nextInt(300 - 200);
		Punto punto =new Punto(xx, yy);
		Perro p = new Perro(punto);
		arreglo[0]=p;
		return arreglo;
	}
	

}
