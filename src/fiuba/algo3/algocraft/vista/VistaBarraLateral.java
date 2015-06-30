package fiuba.algo3.algocraft.vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;

public class VistaBarraLateral extends JTabbedPane implements ObservadorJugador {
    private final Color COLOR_DATOS_JUGADOR_QUE_NO_JUEGA = Color.gray;
    private static final String LABEL_NOMBRE = "Nombre:";
    private static final String LABEL_MINERALES = "Minerales:";
    private static final String LABEL_GAS = "Gas:";
    private static final String LABEL_POBLACION = "Poblacion/MAX:";
	private static final int INDICE_ERROR = 1;

    private Juego modelo;

    private ArrayList<JLabel> labelsJ1 = new ArrayList<JLabel>();
	private JLabel nombreJ1;
	private JLabel mineralJ1;
	private JLabel gasJ1;
	private JLabel poblacionJ1;

    private ArrayList<JLabel> labelsJ2 = new ArrayList<JLabel>();
	private JLabel nombreJ2;
	private JLabel mineralJ2;
	private JLabel gasJ2;
	private JLabel poblacionJ2;

	private JLabel error;
	private Representador representador;

	private JPanel accion;
	
	public VistaBarraLateral(Juego modelo) {
        this.modelo = modelo;
		//hay que modificar para que el tabbedPane se cree desde este constructor
        representador = new Representador();
        int y=0;
        this.setBounds(627, 0, 355, 641);
        JPanel panelPrincipal = new JPanel();

        this.addTab("Informacion", panelPrincipal);
        GridLayout gbl_panelPrincipal = new GridLayout(2,1);
//        gbl_panelPrincipal.columnWidths = new int[]{0, 0, 0, 0, 0};
//        gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        gbl_panelPrincipal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//        gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelPrincipal.setLayout(gbl_panelPrincipal);

        JPanel panelAcciones = new JPanel();
        this.accion = panelAcciones;
        panelPrincipal.add(panelAcciones);
        
        JPanel panelInfos = new JPanel();
        GridBagLayout gbl_panelInfos = new GridBagLayout();
        gbl_panelInfos.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_panelInfos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInfos.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelInfos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInfos.setLayout(gbl_panelInfos);
        panelPrincipal.add(panelInfos);

        JLabel lblInformacionJugador = new JLabel("Informacion Jugador 1");
        GridBagConstraints gbc_lblInformacionJugador = new GridBagConstraints();
        gbc_lblInformacionJugador.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformacionJugador.gridx = 2;
        gbc_lblInformacionJugador.gridy = y;
        panelInfos.add(lblInformacionJugador, gbc_lblInformacionJugador);
        y++;

        JLabel lblNombre = new JLabel(LABEL_NOMBRE);
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = y;
        panelInfos.add(lblNombre, gbc_lblNombre);

        JLabel lblNombreJ1 = new JLabel("");
        this.nombreJ1 = lblNombreJ1;
        GridBagConstraints gbc_lblNombreJ1 = new GridBagConstraints();
        gbc_lblNombreJ1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreJ1.gridx = 2;
        gbc_lblNombreJ1.gridy = y;
        panelInfos.add(lblNombreJ1, gbc_lblNombreJ1);
        y++;

        JLabel lblMinerales = new JLabel(LABEL_MINERALES);
        GridBagConstraints gbc_lblMinerales = new GridBagConstraints();
        gbc_lblMinerales.insets = new Insets(0, 0, 5, 5);
        gbc_lblMinerales.gridx = 1;
        gbc_lblMinerales.gridy = y;
        panelInfos.add(lblMinerales, gbc_lblMinerales);

        JLabel lblCantminj1 = new JLabel("");
        this.mineralJ1 = lblCantminj1;
        GridBagConstraints gbc_lblCantminj1 = new GridBagConstraints();
        gbc_lblCantminj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantminj1.gridx = 2;
        gbc_lblCantminj1.gridy = y;
        panelInfos.add(lblCantminj1, gbc_lblCantminj1);
        y++;

        JLabel lblGas = new JLabel(LABEL_GAS);
        GridBagConstraints gbc_lblGas = new GridBagConstraints();
        gbc_lblGas.insets = new Insets(0, 0, 5, 5);
        gbc_lblGas.gridx = 1;
        gbc_lblGas.gridy = y;
        panelInfos.add(lblGas, gbc_lblGas);


        JLabel lblCantgasj1 = new JLabel("");
        this.gasJ1 = lblCantgasj1;
        GridBagConstraints gbc_lblCantgasj1 = new GridBagConstraints();
        gbc_lblCantgasj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantgasj1.gridx = 2;
        gbc_lblCantgasj1.gridy = y;
        panelInfos.add(lblCantgasj1, gbc_lblCantgasj1);
        y++;

        JLabel lblSuministros = new JLabel(LABEL_POBLACION);
        GridBagConstraints gbc_lblSuministros = new GridBagConstraints();
        gbc_lblSuministros.insets = new Insets(0, 0, 5, 5);
        gbc_lblSuministros.gridx = 1;
        gbc_lblSuministros.gridy = y;
        panelInfos.add(lblSuministros, gbc_lblSuministros);

        JLabel lblPoblacionj1 = new JLabel("");
        this.poblacionJ1 = lblPoblacionj1;
        GridBagConstraints gbc_lblPoblacionj1 = new GridBagConstraints();
        gbc_lblPoblacionj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblPoblacionj1.gridx = 2;
        gbc_lblPoblacionj1.gridy = y;
        panelInfos.add(lblPoblacionj1, gbc_lblPoblacionj1);
        y++;

        JLabel lblInformacionJugador_1 = new JLabel("Informacion Jugador 2");
        GridBagConstraints gbc_lblInformacionJugador_1 = new GridBagConstraints();
        gbc_lblInformacionJugador_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformacionJugador_1.gridx = 2;
        gbc_lblInformacionJugador_1.gridy = y;
        panelInfos.add(lblInformacionJugador_1, gbc_lblInformacionJugador_1);
        y++;

        JLabel label = new JLabel(LABEL_NOMBRE);
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = y;
        panelInfos.add(label, gbc_label);

        JLabel lblNombreJ2 = new JLabel("");
        this.nombreJ2 = lblNombreJ2;
        GridBagConstraints gbc_lblNombreJ2 = new GridBagConstraints();
        gbc_lblNombreJ2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreJ2.gridx = 2;
        gbc_lblNombreJ2.gridy = y;
        panelInfos.add(lblNombreJ2, gbc_lblNombreJ2);
        y++;

        JLabel label_1 = new JLabel(LABEL_MINERALES);
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 1;
        gbc_label_1.gridy = y;
        panelInfos.add(label_1, gbc_label_1);

        JLabel lblCantminj2 = new JLabel("");
        this.mineralJ2 = lblCantminj2;
        GridBagConstraints gbc_lblCantminj2 = new GridBagConstraints();
        gbc_lblCantminj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantminj2.gridx = 2;
        gbc_lblCantminj2.gridy = y;
        panelInfos.add(lblCantminj2, gbc_lblCantminj2);
        y++;

        JLabel label_2 = new JLabel(LABEL_GAS);
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 1;
        gbc_label_2.gridy = y;
        panelInfos.add(label_2, gbc_label_2);

        JLabel lblCantgasj2 = new JLabel("");
        this.gasJ2 = lblCantgasj2;
        GridBagConstraints gbc_lblCantgasj2 = new GridBagConstraints();
        gbc_lblCantgasj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantgasj2.gridx = 2;
        gbc_lblCantgasj2.gridy = y;
        panelInfos.add(lblCantgasj2, gbc_lblCantgasj2);
        y++;

        JLabel label_3 = new JLabel(LABEL_POBLACION);
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.insets = new Insets(0, 0, 5, 5);
        gbc_label_3.gridx = 1;
        gbc_label_3.gridy = y;
        panelInfos.add(label_3, gbc_label_3);

        JLabel lblPoblacionj2 = new JLabel("");
        this.poblacionJ2 = lblPoblacionj2;
        GridBagConstraints gbc_lblPoblacionj2 = new GridBagConstraints();
        gbc_lblPoblacionj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblPoblacionj2.gridx = 2;
        gbc_lblPoblacionj2.gridy = y;
        panelInfos.add(lblPoblacionj2, gbc_lblPoblacionj2);

        JPanel panelError = new JPanel();
        this.addTab("Errores", null, panelError, null);

        JLabel lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panelError.add(lblError);
        this.error = lblError;

        this.labelsJ1.add(this.nombreJ1);
        this.labelsJ1.add(this.gasJ1);
        this.labelsJ1.add(this.mineralJ1);
        this.labelsJ1.add(this.poblacionJ1);

        this.labelsJ2.add(this.nombreJ2);
        this.labelsJ2.add(this.gasJ2);
        this.labelsJ2.add(this.mineralJ2);
        this.labelsJ2.add(this.poblacionJ2);
	}

	public void refrescar() {
		Jugador j1 = this.modelo.getJugadores().get(0);
		Jugador j2 = this.modelo.getJugadores().get(1);
		
		this.nombreJ1.setText(j1.getNombre());
		this.mineralJ1.setText(Integer.toString(j1.getMinerales()));
		this.gasJ1.setText(Integer.toString(j1.getGasVespeno()));
        this.poblacionJ1.setText(Integer.toString(j1.getPoblacion()) + "/" + Integer.toString(j1.getCapacidadDePoblacion()));
		
		this.nombreJ2.setText(j2.getNombre());
		this.mineralJ2.setText(Integer.toString(j2.getMinerales()));
		this.gasJ2.setText(Integer.toString(j2.getGasVespeno()));
        this.poblacionJ2.setText(Integer.toString(j2.getPoblacion()) + "/" + Integer.toString(j2.getCapacidadDePoblacion()));

        if ((this.modelo.getJugadorQueJuega()).equals(this.modelo.getJugadores().get(0))) {
            this.cambiarColorDeLabels(this.labelsJ1, Color.black);
            this.cambiarColorDeLabels(this.labelsJ2, COLOR_DATOS_JUGADOR_QUE_NO_JUEGA);
        }
        else {
            this.cambiarColorDeLabels(this.labelsJ2, Color.black);
            this.cambiarColorDeLabels(this.labelsJ1, COLOR_DATOS_JUGADOR_QUE_NO_JUEGA);
        }

        this.colorearNombres(this.modelo);

        this.repaint();
	}

    private void colorearNombres(Juego modelo) {
        this.nombreJ1.setForeground(this.representador.getColorTexto(modelo.getJugadores().get(0)));
        this.nombreJ2.setForeground(this.representador.getColorTexto(modelo.getJugadores().get(1)));
    }

    private void cambiarColorDeLabels(ArrayList<JLabel> labels, Color color) {
        for (JLabel label: labels)
            label.setForeground(color);
    }
	
	public void setPanelAcciones(JPanel accion){
		this.accion.removeAll();
		this.accion.add(accion);
		this.repaint();
	}
	
	public void displayError(String msg){
		this.setSelectedIndex(INDICE_ERROR);
		this.error.setText(msg);
		this.repaint();
	}

    public void actualizar() {
        this.refrescar();
        this.repaint();
    }
}
