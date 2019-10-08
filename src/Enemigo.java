
public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int puntos;
	protected int monedas;
	
	public abstract void mover();
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
		v.visitEnemigo(this);   // bien
	}

}
