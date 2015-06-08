package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadTerrestre;

public class Marine extends UnidadTerrestre {
    public static int COSTO_MINERAL= 50;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    public static final int SUMINISTRO = 1;
    public static final int VIDA_INICIAL = 40;
    public static final int VISION = 7;
    public static final int CUPO_TRANSPORTE = 1;
    public static final int TIEMPO_DE_CONSTRUCCION = 3;

    public Marine(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        propietario.incrementarPoblacion(SUMINISTRO);
        this.propietario = propietario;
        this.vida = VIDA_INICIAL;
        /*this.danyo = new Danyo(6, 6);*/
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(4, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
}
