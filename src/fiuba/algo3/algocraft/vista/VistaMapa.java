package fiuba.algo3.algocraft.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.ParcelaListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.vista.botones.*;

public class VistaMapa extends JPanel implements ObservadorMapa{
	public static final Color PARCELA_TIERRA = Color.lightGray;
    public static final Color PARCELA_ESPACIO = Color.black;
    public static final Color PARCELA_MINERAL = new Color(0x80C0D2);
    public static final Color PARCELA_VOLCAN = new Color(0xA47861);
    
    public static final String BOTON_PARCELA = "botonParcela";
    public static final String BOTON_INTERACTUABLE = "botonInteractuable";
    
	private int filas;
	private int columnas;
    private final List<JButton> listaBotonesParcela = new ArrayList<JButton>();
    private final List<JPanel> listaPanelesParcela = new ArrayList<JPanel>();
    private Controlador controlador;
    private Coordenada coordenadaSeleccionada;
    private Mapa mapa;
    private Representador representador;
	/**
	 * Create the panel.
	 */
	public VistaMapa(Controlador controlador, Mapa mapa) {
	    this.setVisible(false);
		this.filas=  mapa.getFilas();
		this.columnas = mapa.getColumnas();
		this.controlador = controlador;
		this.representador = new Representador();
		this.mapa = mapa;
		this.setLocation(0, 0);
		this.setSize(650,650);
		this.setLayout(new GridLayout(columnas,filas));
//		this.setLayout(new GridLayout(20,20)); //esto lo comente para poder usar el window builder

		for(int i=0;i<filas*columnas;i++) {

		    int y = i / columnas;
	        int x = i % columnas;

            VistaBotonParcela buttonActual = new VistaBotonParcela(x,y);
            ParcelaListener l = controlador.getParcelaListener();
            buttonActual.addActionListener(l);
            l.setCoordenadasBoton(x,y);
	        listaBotonesParcela.add(buttonActual);
	        
//			this.add(buttonActual);

	        JPanel panelBotones = new JPanel();
	        panelBotones.setLayout(new CardLayout());
	        panelBotones.setBackground(PARCELA_TIERRA); //el mapa se crea con colores de tierra
	        this.add(panelBotones);
	        this.listaPanelesParcela.add(panelBotones);
	        panelBotones.add(buttonActual, BOTON_PARCELA);
        }
	}

    public JButton getButton(int x, int y) {
        int index = y * this.columnas + x;
        return listaBotonesParcela.get(index);
    }

    public VistaBotonInteractuable getBoton(Coordenada coordenada) {
        JPanel panel = this.getPanel(coordenada);

        return (VistaBotonInteractuable) panel.getComponent(panel.getComponentCount() - 1);
    }
    
    public JPanel getPanel(Coordenada coordenada) {
        int index = coordenada.getY() * this.columnas + coordenada.getX();

        return listaPanelesParcela.get(index);
    }

    private void pintarParcela(Coordenada coordenada, Color color){
    	JPanel panelParcela = this.getPanel(coordenada);
    	panelParcela.setBackground(color);
    }
    
    private void agregarElemento(VistaBotonInteractuable buttonActual){   
    	JPanel panelParcela = this.getPanel(this.coordenadaSeleccionada);
    	
    	if(panelParcela.getComponentCount() >1){
    		panelParcela.remove(1);
    	}
    	
    	ParcelaListener l = this.controlador.getParcelaListener();
    	l.setCoordenadasBoton(this.coordenadaSeleccionada.getX(), this.coordenadaSeleccionada.getY());
    	buttonActual.addActionListener(l);

        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
        CardLayout cl = (CardLayout) panelParcela.getLayout();
        cl.show(panelParcela, BOTON_INTERACTUABLE);
    }

//    private void escribirElemento(Interactuable i,int x,int y){
//    	JButton buttonActual = this.representador.getCodigo(i);
//    	
//    	JPanel panelParcela = this.getPanel(new Coordenada(x,y));
//    	
//    	ParcelaListener l = this.controlador.getParcelaListener();
//    	l.setCoordenadasBoton(x,y);
//    	buttonActual.addActionListener(l);
//        buttonActual.setForeground(this.representador.getColorTexto(i.getPropietario()));
//        
//        if(!i.estaCreado()){
//        	buttonActual.setEnabled(false); 
//        }
//        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
//        CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.show(panelParcela, BOTON_INTERACTUABLE);
//    }
    
    private void desinscribirElemento(int x, int y){  //metodo para limpiar la parcela si la unidad se mueve en otra parcela
    	JPanel panelParcela = this.getPanel(new Coordenada(x,y));
    	if(panelParcela.getComponentCount() >1)
    		panelParcela.remove(1);
//    	Component boton = panelParcela.getComponent(1);
//    	CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.removeLayoutComponent(boton);
    }
    
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa {
		//ES SOLO PARA PROBAR QE LAS CONSTR FUNCIONEN
		for(int x=0; x<this.columnas; x++){
    		for(int y=0; y<this.filas; y++){
    			Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
//    			if(!parcela.estaVacia() && (parcela.devolverElemento().getClass().getSuperclass() == Unidad.class)){
//    				this.escribirElemento(parcela.devolverElemento(),x,y);
//    			}
//    			else{
//    				this.desinscribirElemento(x, y);
//    			}
    			if(!parcela.estaVacia() && parcela.devolverElemento().estaCreado())
    					this.activarBoton(parcela.getCoordenada());
    		}
		}
		this.repaint();
	}
	
	public void seleccionarCoordenada(int x, int y){
		this.coordenadaSeleccionada = new Coordenada (x,y);
	}
	
	public void activarBoton(Coordenada coordenada){
		JPanel panel = this.getPanel(coordenada);
		Component boton = panel.getComponent(1);
		boton.setEnabled(true);
	}

	//TODOS ESTOS METODOS PODRIAN IR EN EL REPRESENTADOR Y QUE SEA EL EL OBSERVADOR
	@Override
	public void crearVistaParcela(ParcelaEspacio parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_ESPACIO);
	}

	@Override
	public void crearVistaParcela(ParcelaMineral parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_MINERAL);
	}

	@Override
	public void crearVistaParcela(ParcelaVolcan parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_VOLCAN);
	}

	@Override
	public void crearInteractuable(ArchivosTemplarios archivo) {
		VistaBotonArchivosTemplarios buttonActual = new VistaBotonArchivosTemplarios(archivo);
    	buttonActual.setForeground(this.representador.getColorTexto(archivo.getPropietario()));
        
//        if(!archivo.estaCreado()){
//        	buttonActual.setEnabled(false); 
//        }
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(PuertoEstelar puertoEstelar) {
		VistaBotonPuertoEstelar buttonActual = new VistaBotonPuertoEstelar(puertoEstelar);
    	buttonActual.setForeground(this.representador.getColorTexto(puertoEstelar.getPropietario()));
        
//        if(!puertoEstelar.estaCreado()){
//        	buttonActual.setEnabled(false); 
//        }
        this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Fabrica fabrica) {
		VistaBotonFabrica buttonActual = new VistaBotonFabrica(fabrica);
    	buttonActual.setForeground(this.representador.getColorTexto(fabrica.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(Barraca barraca) {
		VistaBotonBarraca buttonActual = new VistaBotonBarraca(barraca);
    	buttonActual.setForeground(this.representador.getColorTexto(barraca.getPropietario()));
        this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(DepositoSuministro depositoSuministro) {
		VistaBotonDepositoSuministro buttonActual = new VistaBotonDepositoSuministro(depositoSuministro);
    	buttonActual.setForeground(this.representador.getColorTexto(depositoSuministro.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(CentroDeMineral centroDeMineral) {
		VistaBotonCentroMineral buttonActual = new VistaBotonCentroMineral(centroDeMineral);
    	buttonActual.setForeground(this.representador.getColorTexto(centroDeMineral.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(Refineria refineria) {
		VistaBotonRefineria buttonActual = new VistaBotonRefineria(refineria);
    	buttonActual.setForeground(this.representador.getColorTexto(refineria.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(PuertoEstelarProtoss puerto) {
		VistaBotonPuertoEstelarProtoss buttonActual = new VistaBotonPuertoEstelarProtoss(puerto);
    	buttonActual.setForeground(this.representador.getColorTexto(puerto.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(Acceso acceso) {
		VistaBotonAcceso buttonActual = new VistaBotonAcceso(acceso);
    	buttonActual.setForeground(this.representador.getColorTexto(acceso.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(Pilon pilon) {
		VistaBotonPilon buttonActual = new VistaBotonPilon(pilon);
    	buttonActual.setForeground(this.representador.getColorTexto(pilon.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(NexoMineral nexoMineral) {
		VistaBotonNexoMineral buttonActual = new VistaBotonNexoMineral(nexoMineral);
    	buttonActual.setForeground(this.representador.getColorTexto(nexoMineral.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(Asimilador asimilador) {
		VistaBotonAsimilador buttonActual = new VistaBotonAsimilador(asimilador);
    	buttonActual.setForeground(this.representador.getColorTexto(asimilador.getPropietario()));
        this.agregarElemento(buttonActual);
	}

	@Override
	public void crearInteractuable(AltoTemplario templario) {
		VistaBotonAltoTemplario buttonActual = new VistaBotonAltoTemplario(templario);
		buttonActual.setForeground(this.representador.getColorTexto(templario.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Dragon dragon) {
		VistaBotonDragon buttonActual = new VistaBotonDragon(dragon);
		buttonActual.setForeground(this.representador.getColorTexto(dragon.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Espectro espectro) {
		VistaBotonEspectro buttonActual = new VistaBotonEspectro(espectro);
		buttonActual.setForeground(this.representador.getColorTexto(espectro.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Golliat golliat) {
		VistaBotonGolliat buttonActual = new VistaBotonGolliat(golliat);
		buttonActual.setForeground(this.representador.getColorTexto(golliat.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Marine marine) {
		VistaBotonMarine buttonActual = new VistaBotonMarine(marine);
		buttonActual.setForeground(this.representador.getColorTexto(marine.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(NaveCiencia nave) {
		VistaBotonNaveCiencia buttonActual = new VistaBotonNaveCiencia(nave);
		buttonActual.setForeground(this.representador.getColorTexto(nave.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(NaveTransporteProtoss nave) {
		VistaBotonNaveTransporteProtoss buttonActual = new VistaBotonNaveTransporteProtoss(nave);
		buttonActual.setForeground(this.representador.getColorTexto(nave.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(NaveTransporteTerran nave) {
		VistaBotonNaveTransporteTerran buttonActual = new VistaBotonNaveTransporteTerran(nave);
		buttonActual.setForeground(this.representador.getColorTexto(nave.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Scout scout) {
		VistaBotonScout buttonActual = new VistaBotonScout(scout);
		buttonActual.setForeground(this.representador.getColorTexto(scout.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

	@Override
	public void crearInteractuable(Zealot zealot) {
		VistaBotonZealot buttonActual = new VistaBotonZealot(zealot);
		buttonActual.setForeground(this.representador.getColorTexto(zealot.getPropietario()));
		this.agregarElemento(buttonActual);
		
	}

//	@Override
//	public void nuevoTurno() {
//		this.refrescar(this.mapa);
//	}
}