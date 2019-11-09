package GameObjects.Premios.ObjectosPreciosos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Tienda.Tienda;
import Visitor.VisitorPremio;

public class Bomba extends Premio {

	public Bomba(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/bomba.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		

		dibujo.addMouseListener(new MouseAdapter(){			
		    public void mouseClicked(MouseEvent e){  

		    	morir();
				mapa.getGui().setEstadoBotonBomba(true);
				
				Tienda tienda = Tienda.Instancia(null);
				tienda.setBomba(new Bomba(null));
		    }  
		}); 
		
	}

	
}
