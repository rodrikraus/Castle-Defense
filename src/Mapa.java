
public class Mapa {

	protected Celda[][] matriz;
	
	public Mapa() {
		matriz = new Celda[50][100];
		for(int i=0; i<matriz.length; i++)
			for(int j=0; j<matriz[0].length	; j++)
				matriz[i][j] = new Celda();
	}
	
}
