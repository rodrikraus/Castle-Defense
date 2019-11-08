package Juego;

public class Test2 {

	public static void main(String[] args) {
		
		String oleadas = "1ddpjm2mvbppp3"; //1, 2 y 3 indican las diferentes oleadas
		int tiempo = 1000;  //lo pongo aca asi es mas facil de cambiar
		
		for(int i = 0; i < oleadas.length(); i++) {
			switch(oleadas.charAt(i)) {
				case '1': {
					System.out.println("Oleada 1 comenzando.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
				case '2': {
					System.out.println("Oleada 2 comenzando.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
				case '3': {
					System.out.println("Oleada 3 comenzando.");
					try {Thread.sleep(tiempo);} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}
				
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
			}
		}
	}

}
