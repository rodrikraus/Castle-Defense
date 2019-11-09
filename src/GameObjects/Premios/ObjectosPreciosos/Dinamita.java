package GameObjects.Premios.ObjectosPreciosos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.Premios.Premio;
import Juego.Punto;
import Tienda.Tienda;
import Visitor.VisitorMuerteInstantanea;
import Visitor.VisitorPremio;

public class Dinamita extends Premio {

	protected boolean explotado;

	public Dinamita(Punto p, boolean explotado) {
		super();
		punto = p;
		visitor = new VisitorMuerteInstantanea(this);
		this.explotado = explotado;
		
		ruta_dibujo_quieto = "img/mapa/tnt.gif";
		ruta_dibujo_moviendose = null;
		ruta_dibujo_ataque = "img/mapa/explosion_tnt.gif";
		
		if(explotado)
			cambiarDibujo(ruta_dibujo_ataque);
		else
			cambiarDibujo(ruta_dibujo_quieto);
		

		dibujo.addMouseListener(new MouseAdapter(){			
		    public void mouseClicked(MouseEvent e){  

		    	morir();
				mapa.getGui().setEstadoBotonDinamita(true);
				
				Tienda tienda = Tienda.Instancia(null);
				tienda.setDinamita(new Dinamita(null, true));

//				cambiarDibujo(ruta_dibujo_ataque);

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
