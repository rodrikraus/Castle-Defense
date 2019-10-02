
public abstract class Personaje extends GameObject{
	
	protected int danio;
	
	public abstract void morir();

	public int getDanio() {
		return danio;
	}
	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	
	
}
