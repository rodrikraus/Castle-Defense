package GameObjects.Enemigos;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Premios.MagiasTemporales.DobleDanio;
import GameObjects.Premios.MagiasTemporales.DobleOro;
import GameObjects.Premios.ObjectosPreciosos.Bomba;
import GameObjects.Premios.ObjectosPreciosos.Dinamita;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Enemigo extends GameObject   {
	
	protected int puntos;
	protected boolean tiraDobleOro;
	
	public Enemigo(int vida, int danio, int rango, int velMov, int velAt, int puntos, int monedas) {

		// vida, daño, rango, velocidad de Movimiento
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.puntos = puntos;
		this.monedas = monedas;
		tiraDobleOro = false;
	}	
	
	@Override
	public void atacar(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(frecuencia_ataques%velocidad_ataque == 0)
				iniciarAtaque(obj);
			frecuencia_ataques++;
		} else
			morir();
	}
	
	public void iniciarAtaque(GameObject obj) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		disparo.setPunto(p);
		mapa.add(disparo);	
	}
	
	
	public boolean interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();
		
		// Si llegue al castillo, retorno falso
		if (this.punto.getX()<=0)
			return false;
		
		return true;
		
	}
	
	public void mover() {	
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_moviendose));		
		dibujo.setIcon(imagen);
		Rectangle rectangulo = dibujo.getBounds();
		int newX = (int) rectangulo.getX();
		if( newX > 0 ) {
			newX = newX - velocidad_movimiento;		
			punto.setX(newX);
			dibujo.setLocation(newX, (int)rectangulo.getY());
		}		
	}
		
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public void accept(Visitor v){
		v.visit(this);
	} 
	
	public void morir() {        //redefino el metodo morir para tener una chance de tirar un premio cuando muera
		Random random = new Random();
		int numero = random.nextInt(20);
		if(numero<=3) {
			GameObject poder = new DobleOro(new Punto(this.getPunto().getX(), this.getPunto().getY()));
			mapa.add(poder);
		}
		if (numero>=4 && numero<=6) {
			GameObject poder = new DobleDanio(new Punto(this.getPunto().getX(), this.getPunto().getY()));
			mapa.add(poder);
		}
		if(numero>=7 && numero<=9) {
			GameObject poder = new Bomba(new Punto(this.getPunto().getX(), this.getPunto().getY()),false);
			mapa.add(poder);
		}
		if(numero>=10 && numero<=20) {
			GameObject poder = new Dinamita(new Punto(this.getPunto().getX(), this.getPunto().getY()), false);
			mapa.add(poder);
		}
		
		mapa.getListaEliminar().add(this);
		if(tiraDobleOro)
			mapa.getJuego().getTienda().sumarMonedas(monedas*2);
		else 
			mapa.getJuego().getTienda().sumarMonedas(monedas);
		
	}

	public void setDobleDanio(boolean b) {
		//no hace nada
	}
	public void setDobleOro(boolean b) {
		tiraDobleOro = b;
	}

}
