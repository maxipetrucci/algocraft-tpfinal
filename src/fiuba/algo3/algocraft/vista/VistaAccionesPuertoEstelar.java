
package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearCreadorUnidadesMagicasListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesPuertoEstelar  extends VistaAcciones {


	public VistaAccionesPuertoEstelar(Juego modelo, VistaBarraLateral barra, Controlador controlador) {
		super(modelo, barra, controlador);
		
		JButton btnCrearEspectro = new JButton("Crear Espectro");
		btnCrearEspectro.addActionListener(new CrearMarineListener(controlador));
		GridBagConstraints gbc_btnCrearEspectro = new GridBagConstraints();
		gbc_btnCrearEspectro.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearEspectro.gridx = 0;
		gbc_btnCrearEspectro.gridy = 2;
		add(btnCrearEspectro, gbc_btnCrearEspectro);
		

		JButton btnCrearNaveDeTransporte = new JButton("Crear Nave de transporte");
		btnCrearNaveDeTransporte.addActionListener(new CrearMarineListener(controlador));
		GridBagConstraints gbc_btnCrearNaveDeTransporte = new GridBagConstraints();
		gbc_btnCrearNaveDeTransporte.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearNaveDeTransporte.gridx = 0;
		gbc_btnCrearNaveDeTransporte.gridy = 2;
		add(btnCrearNaveDeTransporte, gbc_btnCrearNaveDeTransporte);		
	}

}