package GameObjects.Premios.ObjectosPreciosos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Tienda.Tienda;
import Visitor.VisitorMuerteInstantanea;
import Visitor.VisitorPremio;

public class Bomba extends Premio {


	protected boolean explotado;
	
	public Bomba(Punto p, boolean explotado) {
		super();
		punto = p;
		visitor = new VisitorMuerteInstantanea(this);
		this.explotado = explotado;
		
		ruta_dibujo_quieto = "img/mapa/bomba.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = "img/mapa/explosion_bomba.gif";

		if(explotado) {
			cambiarDibujo(ruta_dibujo_ataque);
			vida = 9999;
		}
		else
			cambiarDibujo(ruta_dibujo_quieto);
		

		dibujo.addMouseListener(new MouseAdapter(){			
		    public void mouseClicked(MouseEvent e){  

		    	morir();
				mapa.getGui().setEstadoBotonBomba(true);
				
				Tienda tienda = Tienda.Instancia(null);
				tienda.setBomba(new Bomba(null, true));
		    }  
		}); 
		
	}

	public void setExplotado(boolean explotado) {
		this.explotado = explotado;
	}


	@Override
	protected boolean getExplotado() {
		return explotado;
	}


	
}
