package GameObjects.Premios.MagiasTemporales;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Visitor.VisitorPremio;

public class DobleOro extends Premio {

	public DobleOro(Punto p) {
		super();
		punto = p;
		visitor = new VisitorPremio(this);

		ruta_dibujo_quieto = "img/mapa/powerupDobleOro.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = null;
		
		cambiarDibujo(ruta_dibujo_quieto);
		
		//accion al clickear
		dibujo.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       mapa.getJuego().activarContadorDobleOro();

		    }  
		}); 

	}

}
