package fiuba.algo3.algocraft.vista;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesUnidad extends VistaAcciones {
	public VistaAccionesUnidad(Juego modelo, VistaBarraLateral barra) {
		super(modelo, barra);
		JButton btnMover = new JButton("Mover");
		GridBagConstraints gbc_btnMover = new GridBagConstraints();
		gbc_btnMover.insets = new Insets(0, 0, 5, 0);
		gbc_btnMover.gridx = 0;
		gbc_btnMover.gridy = 1;
		add(btnMover, gbc_btnMover);
	}

}