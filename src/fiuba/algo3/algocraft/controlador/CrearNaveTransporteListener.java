package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearNaveTransporteListener implements ActionListener {
    private Juego modelo;

	public CrearNaveTransporteListener(Juego modelo){
		this.modelo = modelo;
	}

	public void actionPerformed(ActionEvent arg0) {
		//controlador.crearNaveTransporte();
	}

}
