package GameObjects.Premios.ObjectosPreciosos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Tienda.Tienda;
import Visitor.VisitorPremio;

public class Dinamita extends Premio {


	public Dinamita(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);
		
		ruta_dibujo_quieto = "img/mapa/tnt.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		

		dibujo.addMouseListener(new MouseAdapter(){			
		    public void mouseClicked(MouseEvent e){  

		    	morir();
				mapa.getGui().setEstadoBotonDinamita(true);
				
				Tienda tienda = Tienda.Instancia(null);
				tienda.setToAdd(new Dinamita(null));
		    }  
		}); 

	}

}
