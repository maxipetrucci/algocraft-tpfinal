package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.util.HashMap;

import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;

public class Representador {
	private HashMap<Class, String> codigoElementos;
	private HashMap<Class, Color> coloresParcelas;
    private HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color> coloresDeTextos;
	
	public Representador(){
		this.codigoElementos = new HashMap<Class, String>();
		this.codigoElementos.put(Barraca.class, "Ba");
		this.codigoElementos.put(CentroDeMineral.class, "C.M.");
		this.codigoElementos.put(DepositoSuministro.class, "D.S.");
		this.codigoElementos.put(Fabrica.class, "Fa");
		this.codigoElementos.put(PuertoEstelar.class, "P.E.T.");
		this.codigoElementos.put(Refineria.class, "Re");
		
		this.codigoElementos.put(Espectro.class, "Es");
		this.codigoElementos.put(Golliat.class, "Go");
		this.codigoElementos.put(Marine.class, "Ma");
		this.codigoElementos.put(NaveCiencia.class, "N.C.");
		this.codigoElementos.put(NaveTransporteTerran.class, "N.T.T.");
		
		this.codigoElementos.put(Acceso.class, "Ac");
		this.codigoElementos.put(ArchivosTemplarios.class, "Ar.T.");
		this.codigoElementos.put(Asimilador.class, "As");
		this.codigoElementos.put(NexoMineral.class, "N.M.");
		this.codigoElementos.put(Pilon.class, "Pi");
		this.codigoElementos.put(PuertoEstelarProtoss.class, "P.E.P.");
		
		this.codigoElementos.put(AltoTemplario.class, "A.T.");
		this.codigoElementos.put(Dragon.class, "Dr");
		this.codigoElementos.put(NaveTransporteProtoss.class, "N.T.P.");
		this.codigoElementos.put(Scout.class, "Sc");
		this.codigoElementos.put(Zealot.class, "Ze");

		this.coloresParcelas = new HashMap<Class, Color>();
        this.coloresParcelas.put(ParcelaTierra.class, Color.lightGray);
        this.coloresParcelas.put(ParcelaEspacio.class, Color.black);
        this.coloresParcelas.put(ParcelaVolcan.class, new Color(0xB97A57));
        this.coloresParcelas.put(ParcelaMineral.class, new Color(0x94D8E9));

        this.coloresDeTextos = new HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color>();
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.ROJO, Color.red);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AZUL, Color.blue);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VERDE, Color.green);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AMARILLO, Color.yellow);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.NARANJA, Color.orange);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VIOLETA, new Color(0x9015B2));
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.BLANCO, Color.white);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.CELESTE, new Color(0xEB7F03));
	}
	
	public String getCodigo(Object o){
		return this.codigoElementos.get(o.getClass());
	}

	public Color getColorParcela(Object o) {
		// TODO Auto-generated method stub
		return this.coloresParcelas.get(o.getClass());
	}

    public Color getColorTexto(Jugador j) {
        return this.coloresDeTextos.get(j.getColor());
    }
}
