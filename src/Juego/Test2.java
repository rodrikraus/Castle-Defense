package Juego;

public class Test2 {

	public static void main(String[] args) {
		
		String oleadas = "ddpjm mvbppp";
		int tiempo = 1000;  //lo pongo aca asi es mas facil de cambiar
		
		for(int i = 0; i < oleadas.length(); i++) {
			switch(oleadas.charAt(i)) {
				case 'p': {
					System.out.println("Creando perro.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
			
				case 'd': {
					System.out.println("Creando dragon.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
			
				case 'j': {
					System.out.println("Creando jabali.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				case 'm': {
					System.out.println("Creando mono.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
				case 'b': {
					System.out.println("Creando monstruo violeta.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
				case 'v': {
					System.out.println("Creando vampira.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
				case ' ': {
					System.out.println("Cambiando de oleada.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
			}
		}
	}

}
