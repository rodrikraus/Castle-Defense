import javax.swing.JLabel;

public abstract class GameObject {
	
	protected int vida;
	protected Punto punto;
	protected JLabel dibujo;
	protected int ancho; // o se obtiene del dibujo ??
	protected int largo; // o se obtiene del dibujo ??
	protected Visitor v;
	protected Mapa mapa;
	protected int rango;
	protected int danio;
	
	protected boolean agresivo;
	protected EstrategiaEnemigoInteractuar estrategia;
	
	
	
	public EstrategiaEnemigoInteractuar getEstrategia() {
		return estrategia;
	}
	
	public void setEstrategia(EstrategiaEnemigoInteractuar estrategia) {
		this.estrategia = estrategia;
	}

	public void setAgresivo(boolean b) {
		agresivo = b;
	}
	
	public int getDanio() {
		return danio;
	}
	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public int getRango() {
		return rango;
	}
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Punto getPunto() {
		return punto;
	}
	public void setPunto(Punto p) {
		punto = p;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	public void setDibujo(JLabel dibujo) {
		this.dibujo = dibujo;
	}
	public int getAncho() {
		return ancho;
	}
	
	public int getLargo() {
		return largo;
	}	
	
	public abstract void accept(Visitor v);
	
	public abstract void atacar(GameObject obj); // no se si está bien	

	public abstract void interactuar();

	public Visitor getVisitor() {
		return v;
	}
	
	public void morir() {
		mapa.getListaEliminar().add(this);
		System.out.println("MURIÓ "+this.getClass().toString());
	}
}
