package GameObjects.Enemigos;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoEnemigo;
import GameObjects.Premios.DobleDanio;
import GameObjects.Premios.DobleOro;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Enemigo extends GameObject   {
	
	protected int puntos;
	protected int monedas;
	
	public Enemigo(int vida, int danio, int rango, int velMov, int velAt, int puntos, int monedas) {
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.puntos = puntos;
		this.monedas = monedas;
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
	
	/*
	public void interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();			
	}*/
	
	
	public boolean interactuar() {		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();
		
		if (this.punto.getX()==0)
			return false;
		else return true;
		
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
		/*
		if (newX==0) {
			System.out.println("PERDISTE BOBOLON");
		}*/
		
	}
		
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	} 
	
	public void morir() {        //redefino el metodo morir para tener una chance de tirar un premio cuando muera
		Random random = new Random();
		int numero = random.nextInt(10);
		if(numero<=3) {
			System.out.println("Tirando doble oro al piso.");
			GameObject poder = new DobleOro(new Punto(this.getPunto().getX(), this.getPunto().getY()));
			mapa.add(poder);
		}
		if (numero>=4 && numero<=6) {
			System.out.println("Tirando doble danio al piso.");
			GameObject poder = new DobleDanio(new Punto(this.getPunto().getX(), this.getPunto().getY()));
			mapa.add(poder);
		}
		mapa.getListaEliminar().add(this);
	}

}
