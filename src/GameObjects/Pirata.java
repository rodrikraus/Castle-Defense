package GameObjects;

import Disparos.Disparo;
import Disparos.DisparoAliado;
import Juego.Punto;
import Visitor.VisitorAliado;

public class Pirata extends Aliado {
	
	public Pirata() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Costo
		super(40, 10, 200, 0, 20, 160); 
		visitor = new VisitorAliado(this);
		
		ruta_dibujo_quieto = "img/aliados/pirata.gif";
		ruta_dibujo_ataque = "img/aliados/pirata_ataque.gif";
		ruta_dibujo_moviendose = null;
		
		cambiarDibujo(ruta_dibujo_quieto);  // éste método se encuentra en GameObject
	}	

	@Override
	public void atacar(GameObject obj) {
		frecuencia_ataques++;
		if(vida>0) {  // si estoy vivo, ataco		
			if(frecuencia_ataques%velocidad_ataque== 0)
				disparar();
		} 
		else
			morir();
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			objIntersectado.accept(visitor);
		}
	}	
	
	public void disparar() { 
		flushDibujo(ruta_dibujo_ataque);		
		Punto p = new Punto(punto.getX()+ancho-10, punto.getY()+20);
		Disparo disparo = new DisparoAliado(danio, p, rango);
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);
	}

}
