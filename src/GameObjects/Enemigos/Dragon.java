package GameObjects.Enemigos;

import java.util.Random;

import javax.swing.ImageIcon;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Premios.MagiasTemporales.DobleDanio;
import GameObjects.Premios.MagiasTemporales.DobleOro;
import Juego.Punto;
import Visitor.VisitorEnemigo;

public class Dragon extends Enemigo {
		
	public Dragon() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Puntos, Monedas
		super(40, 5, 100, 3, 20, 35, 30); 
		visitor = new VisitorEnemigo(this);
				
		ruta_dibujo_quieto = null;
		ruta_dibujo_moviendose = "img/enemigos/dragon.gif";
		ruta_dibujo_ataque = "img/enemigos/dragon_ataque.gif";

		cambiarDibujo(ruta_dibujo_moviendose);
	}
	
	public void morir() {        //REDEFINO EL METODO MORIR PARA INDICAR QUE GANO EL JUGADOR
		super.morir();
		mapa.mostrarPantallaGanadora();	
	}
	
	public void iniciarAtaque(GameObject obj) { //REDEFINO PQ EL DRAGON DISPARA UN DISPARO MAS GRANDE
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		disparo.cambiarDibujo("img/disparos/disparo_dragon.gif");
		Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		disparo.setPunto(p);
		mapa.add(disparo);
	}
	

}
