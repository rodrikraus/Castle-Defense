package GameObjects.Aliados;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoAliado;
import Juego.Punto;
import Visitor.VisitorAliado;

public class Golem extends Aliado {
	
	public Golem() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Costo
		super(40, 10, 200, 0, 20, 160); 
		visitor = new VisitorAliado(this);
		
		ruta_dibujo_quieto = "img/aliados/golem.gif";
		ruta_dibujo_ataque = "img/aliados/golem_ataque_sinLoop.gif";
		ruta_dibujo_moviendose = null;
		
		cambiarDibujo(ruta_dibujo_quieto);  // éste método se encuentra en GameObject
		
		activarOyente();
	}	
	
	public void iniciarAtaque(GameObject obj) { //REDEFINO PARA PODER CAMBIAR EL ICONO DEL DISPARO
		flushDibujo(ruta_dibujo_ataque);		
		Punto p = new Punto(punto.getX()+ancho-30, punto.getY());  
		Disparo disparo = new DisparoAliado(danio, p, rango);
		disparo.cambiarDibujo("img/disparos/disparo_golem.gif");
		mapa.add(disparo);
		disparo.setMapa(mapa);
	}

	
	
}
